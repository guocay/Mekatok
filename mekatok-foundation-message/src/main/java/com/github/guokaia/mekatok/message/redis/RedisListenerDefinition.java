package com.github.guokaia.mekatok.message.redis;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.Topic;

import java.util.Collection;

/**
 * 用于定义 redis 监听的信息
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
public interface RedisListenerDefinition {

    /**
     * 获取主题名称
     * @return 主题名称
     */
    Collection<? extends Topic> topic();

    /**
     * 获取处理类
     * @return 处理类
     */
    MessageListener receiver();
}
