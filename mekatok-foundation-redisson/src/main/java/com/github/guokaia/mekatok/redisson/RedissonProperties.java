package com.github.guokaia.mekatok.redisson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Nikita Koksharov
 * @author AnJia (https://anjia0532.github.io/)
 */
@Data
@ConfigurationProperties(prefix = "spring.redis.redisson")
public class RedissonProperties {

    private String config;

    private String file;
}
