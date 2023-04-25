package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.util.ReflectUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;
import icu.guokai.mekatok.framework.core.model.domain.View;

/**
 * 基于View对象的断言工具
 * @author GuoKai
 * @date 2021/10/7
 */
public class ViewAssert<T extends View<?>> extends Assert<ViewAssert<T>, T> {
    /**
     * 构造器
     * @param actual 待断言对象
     */
    public ViewAssert(T actual) {
        super(actual);
    }

    @Override
    public ViewAssert<T> is(T obj) {
        return exception(actual.equals(obj));
    }

    /**
     * 属性值
     * @param key 属性名
     * @param value 属性值
     * @return 断言工具
     */
    public ViewAssert<T> attributes(String key, Object value) {
        try {
            exception(value.equals(ReflectUtil.getFieldValue(actual, key)));
        }catch (Throwable throwable){
            exception();
        }
        return self();
    }
}
