package com.github.guokaia.mekatok.gateway.auth;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.foreign.Exceptions;
import com.github.guokaia.mekatok.gateway.exception.AuthenticationException;
import com.github.guokaia.mekatok.gateway.service.provider.AuthServiceProdiver;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 用于标记需要认证的服务,并对服务进行登录验证
 * @author GuoKai
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

    private static AuthServiceProdiver authService;

    /**
     * JSON 转换
     */
    private static ObjectMapper mapper;

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
            String token = request.getHeaders().getFirst(Global.JWT_TOKEN);
            if(StrUtil.isEmpty(token) || !authService.checkLogin(token).findFirst().getValue()){
                throw Exceptions.create(AuthenticationException.class, "用户未登录!");
            }
            return chain.filter(exchange);
        };
    }

    @Data
    public static class Config{

        /**
         * 不处理的url, 使用 AuthGatewayFilterFactory.SEPARATOR 分隔
         */
        private String exclude;

    }

}
