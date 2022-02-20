package com.github.guokaia.mekatok.gateway.auth;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.token.JwtHolder;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static com.github.guokaia.mekatok.common.Global.AUTHENTICATION_MARK;
import static com.github.guokaia.mekatok.common.Global.BASIC_SERVICE_PATH;

/**
 * GateWay global filter, <br/>
 * 用于添加用户主键字段.
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
@Component
public class AuthMarkGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if(request.getURI().getPath().startsWith(BASIC_SERVICE_PATH)){
            try {
                String token = request.getHeaders().getFirst(Global.JWT_TOKEN);
                ServerHttpRequest rebuild = request.mutate()
                    .header(AUTHENTICATION_MARK, JwtHolder.payload(token)).build();
                return chain.filter(exchange.mutate().request(rebuild).build());
            }catch (Exception ex){
                // Don't do anything.
            }
        }
        return chain.filter(exchange);
    }
}
