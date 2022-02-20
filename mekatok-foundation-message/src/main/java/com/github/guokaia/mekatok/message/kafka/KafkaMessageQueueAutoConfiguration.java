package com.github.guokaia.mekatok.message.kafka;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.util.LinkedList;
import java.util.Map;

/**
 * 配置 kafka 消息队列
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(KafkaTemplate.class)
public class KafkaMessageQueueAutoConfiguration implements BeanPostProcessor, InitializingBean {

    /**
     * 用于存储监听的对象信息
     */
    private LinkedList<KafkaListenerDefinition> listenerDefinitions = new LinkedList<>();

    private final KafkaProperties kafkaProperties;

    public KafkaMessageQueueAutoConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof KafkaListenerDefinition){
            listenerDefinitions.add((KafkaListenerDefinition) bean);
        }
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        listenerDefinitions.forEach(definition -> {
            ContainerProperties properties = new ContainerProperties(definition.topic());
            properties.setMessageListener(definition.listener());

            Map props = kafkaProperties.buildConsumerProperties();
            DefaultKafkaConsumerFactory factory = new DefaultKafkaConsumerFactory<>(props);
            KafkaMessageListenerContainer container = new KafkaMessageListenerContainer<>(factory, properties);

            container.setBeanName(String.format("%s-KafkaListener",definition.toString()));
            container.start();
        });
    }
}
