package com.github.guokaia.mekatok.message.kafka;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * kafka 消息队列的静态工具类
 * @author GuoKai
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@Component
public class KafkaMessageQueueHolder implements BeanFactoryAware {

    private KafkaMessageQueueHolder(){}

    /**
     * kafka 链接模板
     */
    private static KafkaTemplate kafkaTemplate;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.kafkaTemplate = beanFactory.getBean(KafkaTemplate.class);
    }

    /**
     * 发送消息
     * @param topic 主题
     * @param data 数据
     */
    public static void convertAndSend(String topic, Object data){
        kafkaTemplate.send(topic, data);
    }

    /**
     * 发送消息
     * @param topic 主题
     * @param key 键
     * @param data 数据
     */
    public static void convertAndSend(String topic, Object key, Object data){
        kafkaTemplate.send(topic, key, data);
    }

}
