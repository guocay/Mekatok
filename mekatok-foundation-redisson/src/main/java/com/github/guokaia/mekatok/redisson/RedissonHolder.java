package com.github.guokaia.mekatok.redisson;

import org.redisson.api.RLiveObjectService;
import org.redisson.api.RScheduledExecutorService;
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

    @Autowired
    public void setClient(RedissonClient client) {
        RedissonHolder.client = client;
    }

    /**
     * 获取客户端
     * @return 客户端
     */
    public static RedissonClient getClient(){
        return client;
    }

    /**
     * 获取实时对象服务
     * @return 实时对象服务
     */
    public static RLiveObjectService getLiveObjectService(){
        return client.getLiveObjectService();
    }

    /**
     * 获取分布式任务调度
     * @param name 名称
     * @return 分布式任务调度
     */
    public static RScheduledExecutorService getExecutorService(String name){
        return client.getExecutorService(name);
    }
}
