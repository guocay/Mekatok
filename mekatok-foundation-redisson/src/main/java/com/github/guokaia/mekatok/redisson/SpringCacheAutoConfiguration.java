package com.github.guokaia.mekatok.redisson;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring Cache 缓存配置
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/20
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedissonAutoConfiguration.class)
public class SpringCacheAutoConfiguration extends CachingConfigurerSupport implements BeanPostProcessor {


    /**
     * 用于配置缓存组的空闲时间,过期时间和最大长度
     */
    private Map<String, CacheConfig> redissonCacheConfigMap = new HashMap<>();

    @Bean
    @ConditionalOnMissingBean(CacheManager.class)
    public CacheManager cacheManager(RedissonClient redissonClient){
        return new RedissonSpringCacheManager(redissonClient);
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new SpringCacheErrorHandler();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof CacheConfig){
            this.redissonCacheConfigMap.put(beanName, (CacheConfig) bean);
        }
        return bean;
    }
}
