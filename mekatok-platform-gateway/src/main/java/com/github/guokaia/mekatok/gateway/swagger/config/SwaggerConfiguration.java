package com.github.guokaia.mekatok.gateway.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

/**
 * Swagger 配置
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/5
 */
@Configuration(proxyBeanMethods = false)
public class SwaggerConfiguration {

    /**
     * springfox 安全控制器
     * @return 安全控制器
     */
    @Bean
    public SecurityConfiguration securityConfiguration(){
        return SecurityConfigurationBuilder.builder().build();
    }

    /**
     * springfox 页面配置器
     * @return 页面配置器
     */
    @Bean
    public UiConfiguration uiConfiguration(){
        return UiConfigurationBuilder.builder().build();
    }
}
