package icu.guokai.mekatok.framework.cache;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * 平台内缓存中心
 *
 * JSR107 部分注解 使用说明
 * CacheConfig 缓存公共配置,作用于类上.定义当前类缓存公共使用的类. 推荐使用在服务类上
 * Cacheable 获取缓存, 先去缓存中找数据.没有则调用当前函数.得到数据返回,并存储于缓存中. 推荐使用在查询函数中.
 * CachePut 获取缓存, 先执行函数,然后将方法的返回值缓存起来. 推荐使用在更新函数和新增函数中.
 * CacheEvict 清除缓存, beforeInvocation参数为ture先清再执行函数.否则就是先执行函数且不报错后删除函数. 推荐使用在删除函数中.
 * Caching 定义复杂的缓存规则,同时按不同规格生成缓存.一般在一个函数需要多个操作(或操作多个缓存)时用到.
 * @author GuoKai
 * @date 2021/8/18
 */
@SuppressWarnings("all")
public abstract class CacheCenter {

    /**
     * 缓存管理对象
     */
    private static CacheManager manager;

    /**
     * 获取缓存集合
     */
    public static Cache cache(String cache){
        if(ObjectUtil.isNull(manager)){
            manager = SpringUtil.getBean(CacheManager.class);
        }
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
        var value = cache(cache).get(key);
        if (ObjectUtil.isNull(value)){
            return null;
        }
        return value.get();
    }

    /**
     * 在指定缓存集合中取出缓存数据
     * @param cache 缓存集合
     * @param key 缓存的键
     * @param <T> 缓存的值的类型
     * @return 缓存的值
     */
    public static <T extends Serializable> T get(String cache, String key, Class<T> clazz){
        var value = ReflectUtil.newInstance(clazz);
        BeanUtil.copyProperties(get(cache, key), value);
        return value;
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
        return ObjectUtil.isNotNull(get(cache, key));
    }

    /**
     * 获取 Redis 模板 对象
     * @return
     */
    public static RedisTemplate<String, Object> template(){
        return SpringUtil.getBean(RedisTemplate.class);
    }

}
