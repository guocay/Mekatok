package com.github.guokaia.mekatok.gateway.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.foreign.GeneralForeign;
import com.github.guokaia.mekatok.core.exception.MekatokException;
import com.github.guokaia.mekatok.gateway.service.provider.AuthServiceProdiver;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 用于标记需要认证的服务,并对服务进行登录验证
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/8
 */
@SuppressWarnings("all")
@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    /**
     * 分隔符
     */
    private static final String SEPARATOR = ";";

    private static final String SWAGGER_MARK = "/v2/api-docs";


    private AuthServiceProdiver authService;

    private ObjectMapper mapper;

    public AuthGatewayFilterFactory(){
        super(Config.class);
    }

    @Autowired
    public void setAuthService(AuthServiceProdiver authService) {
        this.authService = authService;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("exclude");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if(path.startsWith(SWAGGER_MARK)){
                return chain.filter(exchange);
            }
            for (String url : config.getExclude().split(SEPARATOR)){
                if(path.startsWith(url)){
                    return chain.filter(exchange);
                }
            }
            String tokan = request.getHeaders().getFirst(Global.JWT_TOKEN);
            Boolean login = authService.checkLogin(tokan).findFirst().getValue();
            if(!login){
                return denyAccess(exchange);
            }
            return chain.filter(exchange);
        };
    }

    /**
     * 拦截并返回自定义的json字符串
     */
    @SneakyThrows
    private Mono<Void> denyAccess(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        // 这里在返回头添加编码，否则中文会乱码.
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        byte[] bytes = mapper.writeValueAsBytes(GeneralForeign.of(new MekatokException("用户未登录!")));
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(buffer));
    }

    @Data
    public static class Config{

        /**
         * 不处理的url, 使用 AuthGatewayFilterFactory.SEPARATOR 分隔
         */
        private String exclude;

    }

}
