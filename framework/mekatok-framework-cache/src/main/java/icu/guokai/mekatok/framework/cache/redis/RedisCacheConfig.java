package icu.guokai.mekatok.framework.cache.redis;

import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import icu.guokai.mekatok.framework.cache.key.CacheKeyGenerator;
import icu.guokai.mekatok.framework.cache.redis.deploy.RedisCacheGroup;
import icu.guokai.mekatok.framework.cache.redis.error.RedisCacheErrorHandler;
import icu.guokai.mekatok.framework.core.constant.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;
import java.util.stream.Collectors;

/**
 * Redis缓存实现配置
 * @author GuoKai
 * @date 2021/8/23
 */
@Configuration
@EnableCaching
@SuppressWarnings("all")
public class RedisCacheConfig implements CachingConfigurer {

    /**
     * redis 连接池
     */
    @Autowired
    private RedisConnectionFactory factory;

    @Autowired
    private ObjectMapper mapper;

    /**
     * redis模板
     * @return redis模板
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        var template = new RedisTemplate<String,Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(StringRedisSerializer.UTF_8);
        template.setValueSerializer(serializer());
        // todo 如果存在空的属性,使用默认值.
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 创建序列化规则
     * @return 序列化
     */
    @Bean
    public RedisSerializer<Object> serializer(){
        var serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        serializer.setObjectMapper(mapper);
        return serializer;
    }

    /**
     * 设置缓存管理器
     * @return 缓存管理器
     */
    @Bean
    @Override
    public CacheManager cacheManager() {
        // 获取特有缓存配置
        var confMap = SpringUtil.getBeansOfType(RedisCacheGroup.class).values().stream()
                .collect(Collectors.toMap(RedisCacheGroup::getCache,
                        item -> redisCacheConfiguration().entryTtl(item.getTtl())));

        var manager = RedisCacheManager.builder(factory).withInitialCacheConfigurations(confMap)
                .cacheDefaults(redisCacheConfiguration()).transactionAware().build();
        return manager;
    }

    /**
     * 缓存组 配置
     * @return 配置
     */
    private RedisCacheConfiguration redisCacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(3))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer.UTF_8))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer()))
                .disableCachingNullValues();
    }

    @Bean
    @Override
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver(cacheManager());
    }

    @Override
    @Bean(Global.CACHE_KEY_GENERATOR)
    public KeyGenerator keyGenerator() {
        return CacheKeyGenerator.of();
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        return RedisCacheErrorHandler.of();
    }

}
