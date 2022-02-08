package com.github.guokaia.mekatok.message.kafka;

import org.springframework.kafka.listener.MessageListener;

/**
 * 用于定义 redis 监听的信息
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
public interface KafkaListenerDefinition {


    /**
     * 获取主题名称
     * @return 主题名称
     */
    String[] topic();

    /**
     * kafka的监听响应逻辑
     * @return 消息监听器
     */
    MessageListener<Object, Object> listener();
}
