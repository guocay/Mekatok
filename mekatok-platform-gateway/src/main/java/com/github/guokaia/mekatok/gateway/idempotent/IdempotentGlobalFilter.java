package com.github.guokaia.mekatok.gateway.idempotent;

import com.github.guokaia.mekatok.common.foreign.Exceptions;
import com.github.guokaia.mekatok.context.exception.IdempotentException;
import org.redisson.api.RSetCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

import static com.github.guokaia.mekatok.common.Global.BASIC_SERVICE_PATH;
import static com.github.guokaia.mekatok.common.Global.IDEMPOTENT_GUARANTEE;

/**
 * 网关层用于幂等的保证.
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/20
 */
@SuppressWarnings("all")
@Component
public class IdempotentGlobalFilter implements GlobalFilter {

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

    public IdempotentGlobalFilter(RedissonClient redissonClient,
                                  @Value("${spring.application.name:mekatok-application}") String applicationName,
                                  @Value("${mekatok.token-ttl:30}") Long tokenTtl) {
        this.idempotentCache = redissonClient.getSetCache(applicationName);
        this.tokenTtl = tokenTtl;
        this.applicationName = applicationName;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if(request.getURI().getPath().startsWith(BASIC_SERVICE_PATH)){
            String key = String.format("%s-%s", request.getURI().getPath(),
                request.getHeaders().getFirst(IDEMPOTENT_GUARANTEE));
            if (!idempotentCache.add(key, tokenTtl, TimeUnit.MINUTES)){
                throw Exceptions.create(IdempotentException.class);
            }
        }
        return chain.filter(exchange);
    }

}
