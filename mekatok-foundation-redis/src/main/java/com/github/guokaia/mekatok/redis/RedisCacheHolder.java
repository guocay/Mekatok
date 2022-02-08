package com.github.guokaia.mekatok.redis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 缓存的静态调用工具类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@Component
public class RedisCacheHolder implements BeanFactoryAware {

    private RedisCacheHolder(){}

    /**
     * 缓存管理
     */
    private static CacheManager manager;

    /**
     * redis 链接模板对象
     */
    private static RedisTemplate<String, Object> redisTemplate;

    /**
     * redis 字符串 链接模板对象
     */
    private static StringRedisTemplate stringRedisTemplate;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.manager = beanFactory.getBean(CacheManager.class);
        /*
            name 的值来源于 org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration 类的@Bean注解配置
            这里指定是因为 RedisTemplate 和 StringRedisTemplate 是 父子关系,直接通过类获取会 NoUniqueBeanDefinitionException 哦
         */
        this.redisTemplate = beanFactory.getBean("redisTemplate",RedisTemplate.class);
        this.stringRedisTemplate = beanFactory.getBean(StringRedisTemplate.class);
    }

    /**
     * 获取缓存集合
     * @return 缓存组
     */
    public static Cache cache(String cache){
        return manager.getCache(cache);
    }

    /**
     * 在指定缓存集合中取出缓存数据
     * @param cache 缓存集合
     * @param key 缓存的键
     * @param <T> 缓存的值的类型
     * @return 缓存的值
     */
    public static Object get(String cache, String key){
        Cache.ValueWrapper value = cache(cache).get(key);
        return value == null ? null : value.get();
    }

    /**
     * 在指定缓存集合中取出缓存数据
     * @param cache 缓存集合
     * @param key 缓存的键
     * @param <T> 缓存的值的类型
     * @return 缓存的值
     */
    public static <T> T get(String cache, String key, Class<T> clazz){
        return (T) get(cache, key);
    }

    /**
     * 删除指定缓存集合中的数据.
     * @param cache 缓存集合
     * @param key 缓存的键
     */
    public static void evict(String cache, String key){
        cache(cache).evict(key);
    }

    /**
     * 为指定缓存集合放入数据.
     * 可以用来更新
     * @param cache 缓存集合
     * @param key 缓存的键
     * @param value 缓存的值
     */
    public static void put(String cache, String key, Object value){
        cache(cache).put(key, value);
    }

    /**
     * 为指定缓存集合放入数据.
     * 只能用来新增
     * @param cache 缓存集合
     * @param key 缓存的键
     * @param value 缓存的值
     */
    public static Cache.ValueWrapper putIfAbsent(String cache, String key, Object value){
        return cache(cache).putIfAbsent(key, value);
    }

    /**
     * 缓存中是否存在当前值
     * @param cache 缓存集合
     * @param key 缓存的键
     * @return 是否存在
     */
    public static Boolean exist(String cache, String key){
        return Objects.nonNull(get(cache, key));
    }

    /**
     * 获取 Redis 模板 对象
     * @return 模板对象
     */
    public static RedisTemplate<String, Object> redisTemplate(){
        return redisTemplate;
    }

    /**
     * 获取 Redis 字符 模板 对象
     * @return 字符模板对象
     */
    public static StringRedisTemplate stringRedisTemplate(){
        return stringRedisTemplate;
    }

}
