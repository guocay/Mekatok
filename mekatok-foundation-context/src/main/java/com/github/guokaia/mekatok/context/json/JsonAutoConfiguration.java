package com.github.guokaia.mekatok.context.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.github.guokaia.mekatok.context.spring.SpringContextHolder;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 平台内默认的JSON序列化配置
 * @author GuoKai
 * @date 2022/2/3
 */
@SuppressWarnings("all")
@Import(JsonFormatHolder.class)
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(JacksonAutoConfiguration.class)
public class JsonAutoConfiguration {

    /**
     * Spring容器配置阶段,通过这种方式告诉容器先初始化这个类,下面要用到.无奈...<br/>
     * 其他地方使用建议还是静态方式调用.<br/>
     * 习惯问题,我比较喜欢静态调用.
     */
    private final SpringContextHolder holder;

    public JsonAutoConfiguration(SpringContextHolder holder) {
        this.holder = holder;
    }

    /**
     * 用于在序列化时对空值的转换
     */
    private static final JsonSerializer<Object> NULL_VALUE_SERIALIZER = new JsonSerializer<Object>() {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNull();
        }
    };

    /**
     * 定义转换映射
     * @return 转换映射
     */
    @Bean
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper mapping = new ObjectMapper();
        // 控制转换为 {}
        mapping.getSerializerProvider().setNullValueSerializer(NULL_VALUE_SERIALIZER);
        // 加载序列化和反序列化规则
        JavaTimeModule simpleModule = new JavaTimeModule();
        simpleModule.addSerializer(LocalTime.class,new LocalTimeSerializer(holder.getTimeFormat()))
            .addSerializer(LocalDate.class,new LocalDateSerializer(holder.getDateFormat()))
            .addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(holder.getDateTimeFormat()))
            .addDeserializer(LocalTime.class,new LocalTimeDeserializer(holder.getTimeFormat()))
            .addDeserializer(LocalDate.class,new LocalDateDeserializer(holder.getDateFormat()))
            .addDeserializer(LocalDateTime.class,new LocalDateTimeDeserializer(holder.getDateTimeFormat()));
        // 注册至映射
        mapping.registerModule(simpleModule);
        return mapping;
    }
}
