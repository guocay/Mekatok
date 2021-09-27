package icu.guokai.mekatok.framework.mq.redis.deploy;

import org.springframework.data.redis.connection.MessageListener;

/**
 * 用于指定 信道的名称,处理类及处理函数
 * @author GuoKai
 * @date 2021/8/25
 */
public interface RedisMqListener {
    /**
     * 获取信道名称
     * @return 信道名称
     */
    String channel();

    /**
     * 获取处理类
     * @return 处理类
     */
    MessageListener receiver();

}
