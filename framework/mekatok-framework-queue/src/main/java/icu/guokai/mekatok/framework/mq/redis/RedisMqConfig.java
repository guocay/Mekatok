package icu.guokai.mekatok.framework.mq.redis;

import cn.hutool.extra.spring.SpringUtil;
import icu.guokai.mekatok.framework.mq.redis.deploy.RedisMqListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * redis 消息队列配置
 * @author GuoKai
 * @date 2021/8/25
 */
@Configuration
@SuppressWarnings("all")
public class RedisMqConfig {
    /**
     * redis 连接池
     */
    @Autowired
    private RedisConnectionFactory factory;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){
        var container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);

        // todo 处理项目中声明的通道监听器
        SpringUtil.getBeansOfType(RedisMqListener.class).values()
                .forEach(item -> {
                    container.addMessageListener(
                            new MessageListenerAdapter(item.receiver()),
                            new PatternTopic(item.channel()));
                });
        return container;
    }

}
