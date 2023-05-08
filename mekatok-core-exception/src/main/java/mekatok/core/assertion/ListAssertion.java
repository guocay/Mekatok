package mekatok.core.assertion;

import java.util.List;

/**
 * 集合断言工具
 * @author GuoCay
 * @since 2023.03.10
 */
public class ListAssertion<T> extends AbstractAssertion<ListAssertion<T>, List<T>> {

    public ListAssertion(List<T> actual, boolean nullable) {
        super(actual, nullable);
    }

    /**
     * 判断数组指定槽位的值(使用"=="判断)
     * @param index 数组下标
     * @param obj 值
     * @return 断言工具
     */
    public ListAssertion<T> slot(Integer index, T obj){
        if (actual.size() > index && actual.get(index) != obj)
            throwException();
        return self();
    }

    /**
     * 判断数组长度
     * @param size 数组长度
     * @return 断言工具
     */
    public ListAssertion<T> size(Integer size){
        if (actual.size() != size)
            throwException();
        return self();
    }

    /**
     * 判断数组是否包含 指定元素
     * @param obj 元素
     * @return 断言工具
     */
    public ListAssertion<T> contains(T obj){
        if (!actual.contains(obj))
            throwException();
        return self();
    }

    /**
     * 非空数组
     * @return 断言工具
     */
    public ListAssertion<T> isNotEmpty(){
        if (actual.isEmpty())
            throwException();
        return self();
    }
}
