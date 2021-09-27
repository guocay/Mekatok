package icu.guokai.mekatok.framework.cache.redis.deploy;

import java.time.Duration;

/**
 * 这个类是一个接口,用于在项目中配置单个缓存的设置.
 * 可以声明一个这个接口的子类.并实例化给spring容器.
 * 现在仅做了一个有效期,后续可以根据需求自己加字段.
 * 然后,在RedisCacheConfig类中cacheManager函数关联
 * @author GuoKai
 * @date 2021/8/25
 */
public interface RedisCacheGroup {

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
