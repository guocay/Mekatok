package com.github.guokaia.mekatok.webmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guokaia.mekatok.context.spring.SpringContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * 通用的全局的MVC配置
 * @author GuoKai
 * @date 2022/2/3
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
public class GeneralWebMvcConfigurer implements WebMvcConfigurer, BeanPostProcessor {

    private final ObjectMapper mapper;

    public GeneralWebMvcConfigurer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 注册 消息转换器 至队列
     * @param converters 转换器队列
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(mapper));
    }

    /**
     * 设置 Cors
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").exposedHeaders("*").allowedHeaders("*")
            .allowedMethods("*").allowCredentials(true).maxAge(3600).allowedOrigins("*");
    }

    /**
     * 用于声明一个转换前端发送的日期类字符串
     * @return 日期对象
     */
    @Bean
    public Converter<String, LocalDate> toLocalDate(){
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source, SpringContextHolder.getDateFormat());
            }
        };
    }

    /**
     * 用于声明一个转换前端发送的日期类字符串
     * @return 时间对象
     */
    @Bean
    public Converter<String, LocalTime> toLocalTime(){
        return new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(String source) {
                return LocalTime.parse(source, SpringContextHolder.getTimeFormat());
            }
        };
    }

    /**
     * 用于声明一个转换前端发送的日期类字符串
     * @return 日期时间对象
     */
    @Bean
    public Converter<String, LocalDateTime> toLocalDateTime(){
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, SpringContextHolder.getDateTimeFormat());
            }
        };
    }

    /**
     * 拦截 WebMvcProperties对象的创建过程.
     * 设置当HTTP404时, 抛出异常.而不是返回404页面.
     * 这样就可以在 @RestControllerAdvice 中统一处理.
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof WebMvcProperties){
            WebMvcProperties properties = (WebMvcProperties) bean;
            properties.setThrowExceptionIfNoHandlerFound(true);
        }
        return bean;
    }
}
