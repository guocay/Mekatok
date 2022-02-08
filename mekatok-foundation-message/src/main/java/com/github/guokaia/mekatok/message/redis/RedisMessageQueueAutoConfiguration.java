package com.github.guokaia.mekatok.message.redis;

import com.github.guokaia.mekatok.redis.RedisConnectionAutoConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.LinkedList;

/**
 * redis 消息队列 配置
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisConnectionAutoConfiguration.class)
public class RedisMessageQueueAutoConfiguration implements BeanFactoryAware, BeanPostProcessor {

    /**
     * redis 连接工厂
     */
    private RedisConnectionFactory factory;

    /**
     * redis 信息监听配置
     */
    private LinkedList<RedisListenerDefinition> listenerDefinitions = new LinkedList<>();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = beanFactory.getBean(RedisConnectionFactory.class);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof RedisListenerDefinition){
            listenerDefinitions.add((RedisListenerDefinition) bean);
        }
        return bean;
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        listenerDefinitions.forEach(item -> container.addMessageListener(item.receiver(), item.topic()));
        return container;
    }
}
