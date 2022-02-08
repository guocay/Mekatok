package com.github.guokaia.mekatok.redis;

import java.time.Duration;

/**
 * 用于定义缓存组的信息,当前阶段主要是过期时间
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
public interface RedisCacheDefinition {

    /**
     * 设置缓存名称
     * @return 缓存名称
     */
    String getCache();

    /**
     * 设置缓存过期时间
     * @return 过期时间
     */
    Duration getTtl();
}
