package com.github.guokaia.mekatok.microservice;

import com.github.guokaia.mekatok.microservice.interceptor.CustomFeignInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * openfeign 的自动配置<br/>
 * 定义的 FeignClient 必须在 **.service.provider 包下,才能被扫描进容器
 * @author GuoKai
 * @date 2022/2/2
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@Import(CustomFeignInterceptor.class)
@EnableFeignClients(
    basePackages = "**.service.provider",
    defaultConfiguration = OpenFeignDefaultConfiguration.class
)
public class OpenFeignAutoConfiguration {
}
