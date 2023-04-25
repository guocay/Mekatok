package icu.guokai.mekatok.framework.mq.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 redis mq 支持
 * @author GuoKai
 * @date 2021/8/25
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RedisMqConfig.class)
public @interface EnableRedisMq {
}
