package com.github.guokaia.mekatok.webmvc.whoami;

import com.github.guokaia.mekatok.common.Global;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于将请求中带着的 用户标识 放到当前线程的 ThreadLocal 中.
 * @author GuoKai
 * @date 2022/2/3
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
public class MyselfRegistration {

    @Bean
    public FilterRegistrationBean<MyselfLoaderFilter> myselfLoaderFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyselfLoaderFilter());
        registration.addUrlPatterns(Global.BASIC_SERVICE_PATH + "/*");
        return registration;
    }

    /**
     * 用于处理的Filter
     */
    private class MyselfLoaderFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
            MyselfHolder.load(request.getHeader(Global.AUTHENTICATION_MARK));
            filterChain.doFilter(request, response);
            MyselfHolder.remove();
        }
    }
}
