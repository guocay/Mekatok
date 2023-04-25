package mekatok.core.assertion;

import java.util.Map;

/**
 * Map 断言工具类
 * @author aCay
 * @since 2023.03.10
 */
public class MapAssertion<K,V> extends AbstractAssertion<MapAssertion<K,V>, Map<K,V>>{

    public MapAssertion(Map<K, V> actual, boolean nullable) {
        super(actual, nullable);
    }

    /**
     * 断言是否为空 map
     * @return 断言工具
     */
    public MapAssertion<K, V> isNotEmpty(){
        if (!actual.isEmpty())
            throwException();
        return self();
    }

    /**
     * 断言Map中的数据总量
     * @param count 总数
     * @return 断言工具
     */
    public MapAssertion<K, V> count(Integer count){
        if (actual.size() != count)
            throwException();
        return self();
    }

    /**
     * 断言Map中是否包含指定键
     * @param key 键
     * @return 断言工具
     */
    public MapAssertion<K, V> hasKey(K key){
        if (!actual.containsKey(key))
            throwException();
        return self();
    }

    /**
     * 断言Map中是否包含指定值
     * @param value 值
     * @return 断言工具
     */
    public MapAssertion<K, V> hasValue(V value){
        if (!actual.containsValue(value))
            throwException();
        return self();
    }

    /**
     * 断言Map中是否包含指定键值对
     * @param key 键
     * @param value 值
     * @return 断言工具
     */
    public MapAssertion<K, V> contains(K key, V value){
        if (actual.get(key) != value)
            throwException();
        return self();
    }
}
