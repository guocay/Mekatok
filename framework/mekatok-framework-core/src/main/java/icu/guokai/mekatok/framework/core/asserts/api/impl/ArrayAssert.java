package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.util.ArrayUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 数组 断言
 * @author GuoKai
 * @date 2021/10/6
 */
@SuppressWarnings("all")
public class ArrayAssert<T> extends Assert<ArrayAssert<T>,T[]> {

    /**
     * 构造器
     * @param actual 待断言对象
     */
    public ArrayAssert(T[] actual) {
        super(actual);
    }

    @Override
    public ArrayAssert<T> is(T... objs) {
        return exception(Arrays.equals(actual, objs));
    }

    /**
     * 是空数组
     * @return 断言工具
     */
    public ArrayAssert<T> isEmpty(){
        return exception(ArrayUtil.isEmpty(actual));
    }

    /**
     * 非空数组
     * @return 断言工具
     */
    public ArrayAssert<T> isNotEmpty(){
        return exception(ArrayUtil.isNotEmpty(actual));
    }

    /**
     * 是否包含null元素
     * @return 断言工具
     */
    public ArrayAssert<T> hasNull(){
        return exception(ArrayUtil.hasNull(actual));
    }

    /**
     * 多个字段是否全为null
     * @return 断言工具
     */
    public ArrayAssert<T> isAllNull(){
        return exception(ArrayUtil.isAllNull(actual));
    }

    /**
     * 多个字段是否全部不为null
     * @return 断言工具
     */
    public ArrayAssert<T> isAllNotNull(){
        return exception(ArrayUtil.isAllNotNull(actual));
    }

    /**
     * 是否存都为null或空对象，
     * 通过ObjectUtil.isEmpty(Object) 判断元素
     * @return 断言工具
     */
    public ArrayAssert<T> isAllEmpty(){
        return exception(ArrayUtil.isAllEmpty(actual));
    }

    /**
     * 是否存在null或空对象，
     * 通过ObjectUtil.isEmpty(Object) 判断元素
     * @return 断言工具
     */
    public ArrayAssert<T> hasEmpty(){
        return exception(ArrayUtil.hasEmpty(actual));
    }

    /**
     * 是否存都不为null或空对象，
     * 通过ObjectUtil.isEmpty(Object) 判断元素
     * @return 断言工具
     */
    public ArrayAssert<T> isAllNotEmpty(){
        return exception(ArrayUtil.isAllNotEmpty(actual));
    }

    /**
     * 数组中是否包含元素
     * @return 断言工具
     */
    public ArrayAssert<T> contains(T obj){
        return exception(ArrayUtil.contains(actual, obj));
    }

    /**
     * 数组中是否包含指定元素中的全部
     * @return 断言工具
     */
    public final ArrayAssert<T> containsAll(T... objs){
        return exception(ArrayUtil.containsAll(actual, objs));
    }

    /**
     * 数组中是否包含指定元素中的任意一个
     * @return 断言工具
     */
    public final ArrayAssert<T> containsAny(T... objs){
        return exception(ArrayUtil.containsAny(actual, objs));
    }

    /**
     * 检查数组是否有序，
     * 即comparator.compare(array[i], array[i + 1]) &lt;= 0，
     * 若传入空数组或空比较器，则返回false
     * @return 断言工具
     */
    public ArrayAssert<T> isSorted(Comparator<? super T> comparator){
        return exception(ArrayUtil.isSorted(actual, comparator));
    }

}
