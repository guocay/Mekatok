package com.github.guokaia.mekatok.message.redis;

import com.github.guokaia.mekatok.redisson.RedissonAutoConfiguration;
import com.github.guokaia.mekatok.redisson.RedissonHolder;
import org.redisson.api.listener.StatusListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * redis 消息队列 配置
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedissonAutoConfiguration.class)
@ConditionalOnProperty(name = "mekatok.redis.listener.enable", havingValue = "true")
public class RedisMessageQueueAutoConfiguration implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof StatusListener){
            RedissonHolder.getClient().getTopic(beanName).addListener((StatusListener) bean);
        }
        return bean;
    }
}
