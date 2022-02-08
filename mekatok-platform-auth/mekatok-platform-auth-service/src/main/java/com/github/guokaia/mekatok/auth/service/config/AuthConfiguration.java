package com.github.guokaia.mekatok.auth.service.config;

import com.github.guokaia.mekatok.redis.RedisCacheDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

import static com.github.guokaia.mekatok.common.Global.USER_LOGIN_STATUS_CACHE_NAME;

/**
 * 认证服务配置管理
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/7
 */
@Configuration
public class AuthConfiguration {

    @Bean
    public RedisCacheDefinition userLoginStatusRedisCacheDefinition(){
        return new RedisCacheDefinition() {
            @Override
            public String getCache() {
                return USER_LOGIN_STATUS_CACHE_NAME;
            }

            @Override
            public Duration getTtl() {
                // todo 用户登录有效期设置
                return Duration.ofMinutes(60L);
            }
        };
    }
}
