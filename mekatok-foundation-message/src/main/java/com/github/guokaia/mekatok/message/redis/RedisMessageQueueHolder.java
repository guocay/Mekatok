package com.github.guokaia.mekatok.message.redis;

import com.github.guokaia.mekatok.redisson.RedissonHolder;

/**
 * redis 消息队列的静态工具类
 * @author GuoKai
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
        RedissonHolder.getClient().getTopic(channel).publish(message);
    }

}
