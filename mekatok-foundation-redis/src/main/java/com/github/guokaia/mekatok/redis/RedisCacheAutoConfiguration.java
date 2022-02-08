package com.github.guokaia.mekatok.redis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Redis Cache 自动配置类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@EnableCaching
@Import(RedisCacheHolder.class)
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisConnectionAutoConfiguration.class)
public class RedisCacheAutoConfiguration extends CachingConfigurerSupport implements BeanPostProcessor {


    private static final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

    /**
     * 保存 RedisCacheDefinition
     */
    private LinkedList<RedisCacheDefinition> redisCacheDefinitions = new LinkedList<>();

    /**
     * redis 连接池
     */
    private final RedisConnectionFactory factory;

    /**
     * redis 序列化
     */
    private final RedisSerializer<Object> serializer;

    public RedisCacheAutoConfiguration(RedisConnectionFactory factory, RedisSerializer<Object> serializer) {
        this.factory = factory;
        this.serializer = serializer;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof RedisCacheDefinition){
            redisCacheDefinitions.add((RedisCacheDefinition) bean);
        }
        return bean;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        return buildTemplate(new RedisTemplate<String, Object>());
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(){
        return (StringRedisTemplate) buildTemplate(new StringRedisTemplate());
    }

    private RedisTemplate buildTemplate(RedisTemplate template){
        template.setConnectionFactory(factory);
        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(stringRedisSerializer);
        // 用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        template.setValueSerializer(serializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        Map<String, RedisCacheConfiguration> confMap = redisCacheDefinitions.parallelStream()
            .collect(Collectors.toMap(RedisCacheDefinition::getCache,
                definition -> redisCacheConfiguration().entryTtl(definition.getTtl())));
        CacheManager cacheManager = RedisCacheManager.builder(RedisCacheWriter.lockingRedisCacheWriter(factory))
            .cacheDefaults(redisCacheConfiguration()).initialCacheNames(confMap.keySet())
            .withInitialCacheConfigurations(confMap).transactionAware().build();
        return cacheManager;
    }

    /**
     * 构建 redis 缓存设置
     */
    private RedisCacheConfiguration redisCacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(3))
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
            .disableCachingNullValues();
    }

    @Override
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver(cacheManager());
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new RedisCacheErrorHandler();
    }

}
