package com.github.guokaia.mekatok.redisson.lock;

import java.lang.annotation.*;

/**
 * 基于redisson的读锁
 * @author GuoKai
 * @date 2022/2/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadLock {

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

}
