package icu.guokai.mekatok.framework.core.asserts.api.impl;

import icu.guokai.mekatok.framework.core.asserts.api.Assert;

/**
 * 布尔值 断言工具
 * @author GuoKai
 * @date 2021/10/6
 */
public class BooleanAssert extends Assert<BooleanAssert,Boolean> {

    /**
     * 构造器
     * @param actual 待断言对象
     */
    public BooleanAssert(Boolean actual) {
        super(actual);
    }

    @Override
    public BooleanAssert is(Boolean obj) {
        return exception(actual.equals(obj));
    }

    /**
     * 是真
     * @return 断言工具
     */
    public BooleanAssert isTrue(){
        return is(Boolean.TRUE);
    }

    /**
     * 是假
     * @return 断言工具
     */
    public BooleanAssert isFalse(){
        return is(Boolean.FALSE);
    }

}
