package com.github.guokaia.mekatok.microservice.idempotent;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.foreign.Exceptions;
import com.github.guokaia.mekatok.common.foreign.GeneralForeign;
import com.github.guokaia.mekatok.context.exception.IdempotentException;
import com.github.guokaia.mekatok.context.json.JsonFormatHolder;
import org.redisson.api.RSetCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.github.guokaia.mekatok.common.Global.IDEMPOTENT_GUARANTEE;

/**
 * 抗重放, 保证幂等的过滤器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/20
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(DispatcherServlet.class)
@ConditionalOnProperty(name = "mekatok.idempotent.enable", havingValue = "true")
public class WebIdempotentRegistration {

    @Bean
    public FilterRegistrationBean<IdempotentFilter> idempotentFilter(
            @Value("${spring.application.name:mekatok-application}") String applicationName,
            @Value("${mekatok.token-ttl:30}") Long tokenTtl,
            RedissonClient client){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new IdempotentFilter(applicationName, client, tokenTtl));
        registration.addUrlPatterns(Global.BASIC_SERVICE_PATH + "/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }

    /**
     * 用于拦截请求的filter
     */
    private static class IdempotentFilter extends OncePerRequestFilter {

        /**
         * 分布式幂等缓存
         */
        private final RSetCache<String> idempotentCache;

        /**
         * 幂等有效期与Token有效期一致
         */
        private final Long tokenTtl;

        /**
         * 服务名称
         */
        private final String applicationName;

        public IdempotentFilter(String applicationName, RedissonClient client, Long tokenTtl) {
            this.applicationName = applicationName;
            this.tokenTtl = tokenTtl;
            this.idempotentCache = client.getSetCache(applicationName);
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            String key = String.format("%s-%s",
                request.getRequestURI(), request.getHeader(IDEMPOTENT_GUARANTEE));
            // 放入缓存
            if(!idempotentCache.add(key, tokenTtl, TimeUnit.MINUTES)){
                denyAccess(response);
                return;
            }
            filterChain.doFilter(request, response);
        }

        /**
         * 构建异常信息
         * @param response 响应对象
         * @throws IOException IO异常
         */
        private void denyAccess(HttpServletResponse response) throws IOException {
            GeneralForeign foreign = GeneralForeign.of(Exceptions.create(IdempotentException.class), HttpStatus.FORBIDDEN);
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setCharacterEncoding(Global.DEFAULT_CHARSET_NAME);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().append(JsonFormatHolder.get().writeValueAsString(foreign.setServer(applicationName)));
        }
    }
}
