package icu.guokai.mekatok.framework.plugin.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.json.EnableJsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 用于配置 MVC 的转发和指定以错误页面的注册
 * @author GuoKai
 * @date 2021/8/16
 */
@Configuration
@EnableJsonFormat
@SuppressWarnings("all")
public class WebMvcConfig implements WebMvcConfigurer, ErrorPageRegistrar {

    @Autowired
    private ObjectMapper mapper;

    /**
     * 注册 消息转换器 至队列
     * @param converters 转换器队列
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0,new MappingJackson2HttpMessageConverter(mapper));
    }

    /**
     * 注册 用于处理 异常状态码 的控制器
     * @param registry 异常页面注册
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(
                new ErrorPage(HttpStatus.UNAUTHORIZED, "/" + HttpStatus.UNAUTHORIZED.value()),
                new ErrorPage(HttpStatus.FORBIDDEN, "/" + HttpStatus.FORBIDDEN.value()),
                new ErrorPage(HttpStatus.NOT_FOUND, "/" + HttpStatus.NOT_FOUND.value())
        );
    }

    /**
     * 设置 Cors
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**").allowedOriginPatterns("*").exposedHeaders("*")
                .allowedHeaders("*").allowedMethods("*").allowCredentials(true).maxAge(3600);
    }

    /**
     * 用于声明一个转换前端发送的日期类字符串
     * @return 日期对象
     */
    @Bean
    public Converter<String,LocalDate> toLocalDate(){
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source,DateTimeFormatter.ofPattern(Global.DATE_FORMAT));
            }
        };
    }

    /**
     * 用于声明一个转换前端发送的日期类字符串
     * @return 时间对象
     */
    @Bean
    public Converter<String,LocalTime> toLocalTime(){
        return new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(String source) {
                return LocalTime.parse(source,DateTimeFormatter.ofPattern(Global.TIME_FORMAT));
            }
        };
    }

    /**
     * 用于声明一个转换前端发送的日期类字符串
     * @return 日期时间对象
     */
    @Bean
    public Converter<String,LocalDateTime> toLocalDateTime(){
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source,DateTimeFormatter.ofPattern(Global.DATETIME_FORMAT));
            }
        };
    }
}
