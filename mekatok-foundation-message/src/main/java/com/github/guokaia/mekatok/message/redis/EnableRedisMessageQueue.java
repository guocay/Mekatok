package com.github.guokaia.mekatok.message.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 redis 消息队列配置
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({RedisMessageQueueAutoConfiguration.class})
public @interface EnableRedisMessageQueue {
}
