package icu.guokai.mekatok.framework.stomp.configure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 websocket stomp 消息队列
 * @author GuoKai
 * @date 2021/8/24
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({StompConfiguration.class})
public @interface EnableWsStomp {
}
