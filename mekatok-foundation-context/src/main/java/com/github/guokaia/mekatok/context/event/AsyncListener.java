package com.github.guokaia.mekatok.context.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.lang.annotation.*;

/**
 * 异步事件监听
 * 作为 @EventListener 的延伸
 * @author GuoKai
 * @date 2022/2/1
 */
@Async
@EventListener
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AsyncListener {
}
