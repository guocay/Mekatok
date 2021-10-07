package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.util.NumberUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;

import java.util.Arrays;
import java.util.Map;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class MapAssert<K,V> extends Assert<MapAssert<K,V>, Map<K,V>> {

    /**
     * 构造器
     * @param actual 待断言对象
     */
    public MapAssert(Map<K,V> actual) {
        super(actual);
    }

    @Override
    public MapAssert<K, V> is(Map<K, V> obj) {
        return exception(actual.equals(obj));
    }

    public MapAssert<K, V> isEmpty(){
        return exception(actual.isEmpty());
    }

    public MapAssert<K, V> isNotEmpty(){
        return exception(!actual.isEmpty());
    }

    public MapAssert<K, V> count(Integer count){
        return exception(actual.size() == count);
    }

    public MapAssert<K, V> hasKey(K... keys){
        return exception(NumberUtil.equals(keys.length, Arrays.stream(keys).filter(actual::containsKey).count()));
    }

    public MapAssert<K, V> notHasKey(K key){
        return exception(!actual.containsKey(key));
    }

    public MapAssert<K, V> hasValue(V... values){
        return exception(NumberUtil.equals(values.length, Arrays.stream(values).filter(actual::containsValue).count()));
    }

    public MapAssert<K, V> notHasValue(V value){
        return exception(!actual.containsValue(value));
    }

    public MapAssert<K, V> contains(K key, V value){
        try {
            exception(actual.get(key).equals(value));
        }catch (Throwable throwable){
            exception();
        }
        return self();
    }

}
