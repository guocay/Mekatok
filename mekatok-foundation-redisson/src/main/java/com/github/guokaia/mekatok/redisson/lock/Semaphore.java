package com.github.guokaia.mekatok.redisson.lock;

import java.lang.annotation.*;

/**
 * 基于redisson的信号量
 * @author GuoKai
 * @date 2022/2/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Semaphore {

    /**
     * 获取锁名称
     * @return 锁名称
     */
    String value();

    /**
     * 执行需要的信号量
     * @return 许可证数量
     */
    int permits() default 1;

}
