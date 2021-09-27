package icu.guokai.mekatok.framework.security.configure.simple;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启简单的登录授权控制
 * 无需统一认证服务器支持
 * @author GuoKai
 * @date 2021/8/18
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SimpleSecurityConfiguration.class)
public @interface EnableSimpleSecurity {
}
