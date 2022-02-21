package com.github.guokaia.mekatok.context.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Mekatok 应用上下文自动化配置
 * @author GuoKai
 * @date 2022/1/26
 */
@SuppressWarnings("all")
@Import({
    SpringMessageSource.class,
    SpringContextHolder.class
})
@Configuration(proxyBeanMethods = false)
public class SpringAutoConfiguration {
}
