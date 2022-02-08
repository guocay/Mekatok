package com.github.guokaia.mekatok.message.redis;

import com.github.guokaia.mekatok.redis.RedisCacheHolder;

/**
 * redis 消息队列的静态工具类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
public class RedisMessageQueueHolder {

    private RedisMessageQueueHolder(){}

    /**
     * 向指定队列推送消息
     * @param channel 通道
     * @param message 消息
     */
    public static void convertAndSend(String channel,String message){
        RedisCacheHolder.redisTemplate().convertAndSend(channel,message);
    }

}
