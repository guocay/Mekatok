package icu.guokai.mekatok.framework.core.collect;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

/**
 * 一个基于 hashmap 的计数器 <br/>
 * PS: 一定 一定 一定 要重写 key 的 equal 函数啊!!!
 * @author GuoKai
 * @date 2021/10/8
 */
public class HashMultiSet<E> extends HashMap<E, Integer> implements MultiSet<E> {

    private static final long serialVersionUID = 128343812765761588L;

    @Override
    public void add(E element) {
        add(element,1);
    }

    @Override
    public void empty(E element) {
        setCount(element,0);
    }

    @Override
    public boolean contains(E element) {
        return containsKey(element);
    }

    @Override
    public int count(E element) {
        return get(element);
    }

    @Override
    public Set<E> elementSet() {
        return keySet();
    }

    @Override
    public void reduce(E element) {
        reduce(element,1);
    }

    @Override
    public int setCount(E element, int count) {
        return Optional.ofNullable(put(element, count)).orElse(0);
    }

    @Override
    public int add(E element, int occurrences) {
        return merge(element,occurrences,Integer::sum);
    }

    @Override
    public int reduce(E element, int occurrences) {
        return merge(element,occurrences,(oldValue,newValue) -> oldValue - newValue);
    }

}
