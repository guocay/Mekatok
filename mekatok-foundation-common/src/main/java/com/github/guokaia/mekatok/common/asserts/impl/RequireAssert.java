package com.github.guokaia.mekatok.common.asserts.impl;

import cn.hutool.core.util.ReflectUtil;
import com.github.guokaia.mekatok.common.asserts.AbstractAssert;
import com.github.guokaia.mekatok.core.model.Require;

/**
 * 基于Transport对象的断言工具
 * @author GuoKai
 * @date 2021/10/7
 */
public class RequireAssert<T extends Require> extends AbstractAssert<RequireAssert<T>, T> {

    /**
     * 构造器
     * @param actual 待断言对象
     */
    public RequireAssert(T actual) {
        super(actual);
    }

    @Override
    public RequireAssert<T> is(T obj) {
        return exception(actual.equals(obj));
    }

    /**
     * 属性值
     * @param key 属性名
     * @param value 属性值
     * @return 断言工具
     */
    public RequireAssert<T> attributes(String key, Object value) {
        try {
            exception(value.equals(ReflectUtil.getFieldValue(actual, key)));
        }catch (Throwable throwable){
            exception();
        }
        return self();
    }

}
