package com.github.guokaia.mekatok.redisson.lock;

import java.lang.annotation.*;

/**
 * 基于redisson实现的可重入锁
 * @author GuoKai
 * @date 2022/2/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Lock {

    /**
     * 获取锁名称
     * @return 锁名称
     */
    String value();

    /**
     * 自动开锁时间
     * @return 开锁时间
     */
    long autoUnlockSeconds() default -1L;

    /**
     * 等待加锁时间
     * @return 加锁时间
     */
    long awitLockSeconds() default -1L;

    /**
     * 是否异步执行
     * @return 是否
     */
    boolean isAsync() default false;

    /**
     * 是否公平锁
     * @return 是否
     */
    boolean isFair() default false;

}
