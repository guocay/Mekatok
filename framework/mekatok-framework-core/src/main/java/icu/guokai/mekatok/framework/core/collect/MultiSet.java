package icu.guokai.mekatok.framework.core.collect;

import java.util.Set;

/**
 * 一个用于计数的Set集合
 * @author GuoKai
 * @date 2021/10/8
 */
public interface MultiSet<E> {

    /**
     * 增加计数 +1
     * @param element 元素
     */
    void add(E element);

    /**
     * 增加计数 +occurrences
     * @param element 元素
     * @param occurrences 计数
     */
    int add(E element,int occurrences);

    /**
     * 减少计数 +1
     * @param element 元素
     */
    void reduce(E element);

    /**
     * 减少计数 +occurrences
     * @param element 元素
     * @param occurrences 计数
     */
    int reduce(E element,int occurrences);

    /**
     * 清零
     * @param element 元素
     */
    void empty(E element);

    /**
     * 是否包含
     * @param element 元素
     * @return 是否包含
     */
    boolean contains(E element);

    /**
     * 获取元素的计数
     * @param element 元素
     * @return 计数
     */
    int count(E element);

    /**
     * 获取元素集合
     * @return 集合
     */
    Set<E> elementSet();

    /**
     * 设置元素计数
     * @param element 元素
     * @param count 计数
     * @return 计数
     */
    int setCount(E element, int count);

}
