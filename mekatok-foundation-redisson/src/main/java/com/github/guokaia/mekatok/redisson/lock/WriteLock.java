package com.github.guokaia.mekatok.redisson.lock;

import java.lang.annotation.*;

/**
 * 基于redisson的写锁
 * @author GuoKai
 * @date 2022/2/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteLock {
}
