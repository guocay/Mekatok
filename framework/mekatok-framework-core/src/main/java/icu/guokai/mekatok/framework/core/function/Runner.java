package icu.guokai.mekatok.framework.core.function;

import icu.guokai.mekatok.framework.core.asserts.WithAssertions;

/**
 * 用于自定义断言的lambda接口
 * @author GuoKai
 * @date 2021/8/5
 */
@FunctionalInterface
public interface Runner extends WithAssertions {

    /**
     * 无参无返回值
     */
    void run();

}
