package icu.guokai.mekatok.framework.core.task;

import icu.guokai.mekatok.framework.core.asserts.WithAssertions;

/**
 * 用于定义执行接口
 * @author GuoKai
 * @date 2021/8/31
 */
@FunctionalInterface
public interface AsyncTask extends Runnable, WithAssertions {

    /**
     * 异步执行启动延迟
     * @return 默认返回 0
     */
    default Long startTimeout(){
        return 0L;
    }

}
