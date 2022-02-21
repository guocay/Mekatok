package com.github.guokaia.mekatok.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * redis 缓存异常处理类
 * @author GuoKai
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@Slf4j
public class SpringCacheErrorHandler implements CacheErrorHandler {

    /**
     * 获取异常处理
     * @param exception 异常信息
     * @param cache 缓存类
     * @param key 键
     */
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        log.error("Redis 数据缓存获取失败...",exception);
    }

    /**
     * 推送异常处理
     * @param exception 异常信息
     * @param cache 缓存类
     * @param key 键
     * @param value 值
     */
    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        log.error("Redis 数据缓存推送失败...",exception);
    }

    /**
     * 删除异常处理
     * @param exception 异常信息
     * @param cache 缓存类
     * @param key 键
     */
    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        log.error("Redis 数据缓存删除失败...",exception);
    }

    /**
     * 清空异常处理
     * @param exception 异常信息
     * @param cache 缓存类
     */
    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        log.error("Redis 数据缓存清空失败...",exception);
    }
}
