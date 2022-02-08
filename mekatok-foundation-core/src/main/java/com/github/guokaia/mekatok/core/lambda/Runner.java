package com.github.guokaia.mekatok.core.lambda;

/**
 * 一个 无参 无返回值 的 lambda 表达式 接口
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
@FunctionalInterface
public interface Runner {

    /**
     * 无参无返回值
     */
    void run() throws Throwable;
}
