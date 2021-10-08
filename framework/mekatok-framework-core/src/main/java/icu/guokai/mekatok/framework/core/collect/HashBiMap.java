package icu.guokai.mekatok.framework.core.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 基于HashCode的BiMap
 * @author GuoKai
 * @date 2021/10/8
 */
@SuppressWarnings("all")
public class HashBiMap<K,V> extends HashMap<K,V> implements BiMap<K,V> {

    private static final long serialVersionUID = -7093227203968892239L;

    public HashBiMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public HashBiMap(int initialCapacity) {
        super(initialCapacity);
    }

    public HashBiMap() {
        super();
    }

    public HashBiMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    /**
     * 校验 值 是否已经存在
     * @param value 值
     * @return 值
     */
    private V check(V value){
        if(containsValue(value)){
            throw new IllegalArgumentException("value already present: " + value);
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, check(value));
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return super.putIfAbsent(key, check(value));
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return super.replace(key, oldValue, check(newValue));
    }

    @Override
    public V replace(K key, V value) {
        return super.replace(key, check(value));
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        forEach((key,value) -> {
            replace(key, check(function.apply(key, value)));
        });
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return replace(key, check(remappingFunction.apply(key,get(key))));
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return replace(key, check(mappingFunction.apply(key)));
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return replace(key, check(remappingFunction.apply(get(key),value)));
    }

    @Override
    public Map<V, K> inverse() {
        var map = new HashMap<V, K>(size());
        forEach((key, value) -> map.put(value,key));
        return map;
    }
}
