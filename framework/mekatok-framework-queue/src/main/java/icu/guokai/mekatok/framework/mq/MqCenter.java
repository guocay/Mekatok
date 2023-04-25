package icu.guokai.mekatok.framework.mq;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 消息队列辅助中心
 * @author GuoKai
 * @date 2021/8/25
 */
@SuppressWarnings("all")
public abstract class MqCenter {

    /**
     * 获取 Redis 模板 对象
     * @return redis 模板
     */
    public static RedisTemplate<String, Object> template(){
        return SpringUtil.getBean(RedisTemplate.class);
    }

    /**
     * 向指定队列推送消息
     * @param channel 通道
     * @param message 消息
     */
    public static void convertAndSend(String channel,String message){
        template().convertAndSend(channel,message);
    }
}
