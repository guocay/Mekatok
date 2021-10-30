package icu.guokai.mekatok.framework.core.collect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 基于 hashmap与ArrayList 的MultiMap
 * @author GuoKai
 * @date 2021/10/8
 */
public class ArrayMultiMap<K, V> extends HashMap<K, Collection<V>> implements MultiMap<K, V>{

    private static final long serialVersionUID = -1182381255976579546L;

    /**
     * 创建 ArrayMultiMap
     * @return ArrayMultiMap
     */
    public static <T,P> MultiMap<T,P> create() {
        return new ArrayMultiMap<T,P>();
    }

    /**
     * 检查当前key指向的集合是否为空,
     * 为空则创建
     * @param key 键
     * @return 集合
     */
    private Collection<V> check(K key){
        return Optional.ofNullable(get(key)).orElse(put(key, new ArrayList<V>()));
    }

    @Override
    public void add(K key, V value) {
        check(key).add(value);
    }

    @Override
    @SafeVarargs
    public final void addAll(K key, V... values) {
        check(key).addAll(Arrays.asList(values));
    }

    @Override
    public void delete(K key, V value) {
        var list = get(key);
        if(list != null){
            list.remove(value);
        }
    }

    @Override
    public Integer size(K key) {
        var value = get(key);
        if(value != null){
            return value.size();
        }
        return 0;
    }

    @Override
    public Integer sizeAll(K key) {
        return values().parallelStream().mapToInt(Collection::size).sum();
    }

    @Override
    public boolean keyContainsValue(K key, V value) {
        var list = get(key);
        if (list != null){
            return list.contains(value);
        }
        return false;
    }

    @Override
    public boolean contains(V value) {
        return keySet().parallelStream().anyMatch(key -> keyContainsValue(key, value));
    }

    @Override
    public Collection<V> valueAll() {
        return values().parallelStream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
