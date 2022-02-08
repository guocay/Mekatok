package com.github.guokaia.mekatok.common.asserts.impl;

import com.github.guokaia.mekatok.common.asserts.AbstractAssert;

/**
 * 布尔值 断言工具
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
public class BooleanAssert extends AbstractAssert<BooleanAssert,Boolean> {

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
