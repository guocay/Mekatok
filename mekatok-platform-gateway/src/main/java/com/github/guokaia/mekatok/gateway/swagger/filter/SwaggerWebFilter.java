package com.github.guokaia.mekatok.gateway.swagger.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 用于将 swagger的doc.html 转发至 根路径
 * @author GuoKai
 * @date 2022/1/31
 */
@SuppressWarnings("all")
@Component
public class SwaggerWebFilter implements WebFilter {

    /**
     * 请求的 根路径
     */
    private static final String ROOT_PATH_CONTEXT = "/";

    /**
     * 转发 根路径
     * @param exchange ServerWebExchange
     * @param chain WebFilterChain
     * @return Mono
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (ROOT_PATH_CONTEXT.equals(exchange.getRequest().getURI().getPath())) {
            ServerWebExchange webExchange = exchange.mutate().request(exchange.getRequest().mutate().path("/doc.html").build()).build();
            return chain.filter(webExchange);
        }
        return chain.filter(exchange);
    }
}
