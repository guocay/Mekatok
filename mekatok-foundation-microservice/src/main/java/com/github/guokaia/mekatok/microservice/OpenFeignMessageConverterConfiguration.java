package com.github.guokaia.mekatok.microservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guokaia.mekatok.context.json.JsonAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 消息自动配置
 * @author GuoKai
 * @date 2022/2/8
 */
@Configuration
@AutoConfigureAfter(JsonAutoConfiguration.class)
public class OpenFeignMessageConverterConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectMapper objectMapper) {
        return new HttpMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
