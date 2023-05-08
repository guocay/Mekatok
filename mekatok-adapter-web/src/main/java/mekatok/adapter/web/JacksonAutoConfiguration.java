package mekatok.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Jackson 自动化配置类
 * @author GuoCay
 * @since 2023.03.10
 */
@Configuration(proxyBeanMethods = false)
public class JacksonAutoConfiguration {

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        // 设置 只关注 非空的值, 即忽略 null 值.
        mapper.setSerializationInclusion(NON_NULL);
        return mapper;
    }

}
