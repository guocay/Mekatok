package icu.guokai.mekatok.framework.cache.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 redis 缓存实现
 * @author GuoKai
 * @date 2021/8/23
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RedisCacheConfig.class)
public @interface EnableRedisCache {
}
