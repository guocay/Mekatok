package com.github.guokaia.mekatok.core.lambda;

/**
 * 一个 无参 无返回值 的 lambda 表达式 接口
 * @author GuoKai
 * @date 2022/2/2
 */
@FunctionalInterface
public interface Runner {

    /**
     * 无参无返回值
     */
    void run() throws Throwable;
}
