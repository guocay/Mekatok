package icu.guokai.mekatok.framework.plugin.web;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启HTTP协议访问
 * 平台默认关闭HTTP访问端口,此注解用于开启HTTP协议访问.
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({TomcatHttpConfig.class, WebMvcConfig.class, WebMvcRouter.class})
public @interface EnableServer { }
