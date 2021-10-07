package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.collection.CollUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class CollectionAssert<T> extends Assert<CollectionAssert<T>, Collection<T>> {
    /**
     * 构造器
     * @param actual 待断言对象
     */
    public CollectionAssert(Collection<T> actual) {
        super(actual);
    }

    @Override
    public CollectionAssert<T> is(Collection<T> obj) {
        return exception(CollUtil.isEqualList(actual, obj));
    }

    /**
     * 判断下标的元素
     * @param obj 元素
     * @param index 下标
     * @return 断言工具
     */
    public CollectionAssert<T> is(T obj, Integer index){
        try{
            exception(((List<T>)actual).get(index).equals(obj));
        }catch (Throwable ex){
            exception();
        }
        return self();
    }

    /**
     * 包含任意元素
     * @param obj 元素
     * @return 断言工具
     */
    public CollectionAssert<T> containsAny(Collection<T> obj){
        return exception(CollUtil.contains(actual, obj));
    }

    /**
     * 包含任意元素
     * @param obj 元素
     * @return 断言工具
     */
    @SafeVarargs
    public final CollectionAssert<T> containsAny(T... obj){
        return containsAny(Arrays.asList(obj));
    }

    /**
     * 包含指定元素
     * @param obj 元素
     * @return 断言工具
     */
    public CollectionAssert<T> withIn(T obj){
        return exception(CollUtil.contains(actual, obj));
    }

    /**
     * 不包含指定元素
     * @param obj 元素
     * @return 断言工具
     */
    public CollectionAssert<T> outSide(T obj){
        return exception(!CollUtil.contains(actual, obj));
    }

    /**
     * 是空数组
     * @return 断言工具
     */
    public CollectionAssert<T> isEmpty(){
        return exception(CollUtil.isEmpty(actual));
    }

    /**
     * 非空数组
     * @return 断言工具
     */
    public CollectionAssert<T> isNotEmpty(){
        return exception(CollUtil.isNotEmpty(actual));
    }

    /**
     * 数组元素中存在 null
     * @return 断言工具
     */
    public CollectionAssert<T> hasNull(){
        return exception(CollUtil.hasNull(actual));
    }

    /**
     * 字符串长度等于
     * @param count 长度
     * @return 断言工具
     */
    public CollectionAssert<T> count(Integer count){
        return exception(actual.size() == count);
    }

    /**
     * 字符串长度小于
     * @param less 长度
     * @return 断言工具
     */
    public CollectionAssert<T> less(Integer less){
        return exception(actual.size() < less);
    }

    /**
     * 字符串长度大于
     * @param greater 长度
     * @return 断言工具
     */
    public CollectionAssert<T> greater(Integer greater){
        return exception(actual.size() > greater);
    }

}
