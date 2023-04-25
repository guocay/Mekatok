package icu.guokai.mekatok.framework.core.collect;

import java.util.Collection;
import java.util.Map;

/**
 * 一个 value是集合 的map
 * @author GuoKai
 * @date 2021/10/8
 */
@SuppressWarnings("all")
public interface MultiMap<K, V> extends Map<K, Collection<V>> {

    /**
     * 添加元素
     * @param key 键
     * @param value 元素
     */
    void add(K key, V value);

    /**
     * 添加元素
     * @param key 键
     * @param values 元素集合
     */
    void addAll(K key, V... values);

    /**
     * 删除元素
     * @param key 键
     * @param value 值
     */
    void delete(K key, V value);

    /**
     * 键的元素计数
     * @param key 键
     * @return 计数
     */
    Integer size(K key);


    /**
     * 元素计数
     * @param key 键
     * @return 计数
     */
    Integer sizeAll(K key);

    /**
     * 判断key里是否存在元素
     * @param key 键
     * @param value 值
     * @return 是否包含
     */
    boolean keyContainsValue(K key, V value);

    /**
     * 判断对象里是否存在元素
     * @param value 值
     * @return 是否包含
     */
    boolean contains(V value);

    /**
     * 所有值的集合
     * @return 集合
     */
    Collection<V> valueAll();

}
