package com.github.guokaia.mekatok.redisson;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Redisson Cache 持有者
 * @author GuoKai
 * @date 2022/2/20
 */
@Component
public class RedissonHolder {

    /**
     * redisson 客户端
     */
    private static RedissonClient client;

    private RedissonHolder(){}

    /**
     * 获取客户端
     * @return 客户端
     */
    public static RedissonClient getClient(){
        return client;
    }

    @Autowired
    public void setClient(RedissonClient client) {
        RedissonHolder.client = client;
    }
}
