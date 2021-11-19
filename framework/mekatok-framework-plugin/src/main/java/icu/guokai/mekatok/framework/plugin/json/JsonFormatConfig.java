package icu.guokai.mekatok.framework.plugin.json;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author GuoKai
 * @date 2021/11/19
 */
@Configuration
@SuppressWarnings("all")
public class JsonFormatConfig {

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
    public ObjectMapper defaultObjectMapping() {
        var mapping = new ObjectMapper();
        // 控制转换为 {}
        mapping.getSerializerProvider().setNullValueSerializer(NULL_VALUE_SERIALIZER);
        //加载序列化和反序列化规则
        var simpleModule = new SimpleModule();
        simpleModule.addSerializer(LocalTime.class,new LocalTimeSerializer(DateTimeFormatter.ofPattern(Global.TIME_FORMAT)))
                .addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter.ofPattern(Global.DATE_FORMAT)))
                .addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(Global.DATETIME_FORMAT)))
                .addDeserializer(LocalTime.class,new LocalTimeDeserializer(DateTimeFormatter.ofPattern(Global.TIME_FORMAT)))
                .addDeserializer(LocalDate.class,new LocalDateDeserializer(DateTimeFormatter.ofPattern(Global.DATE_FORMAT)))
                .addDeserializer(LocalDateTime.class,new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(Global.DATETIME_FORMAT)));
        //注册至映射
        mapping.registerModule(simpleModule);
        return mapping;
    }

}
