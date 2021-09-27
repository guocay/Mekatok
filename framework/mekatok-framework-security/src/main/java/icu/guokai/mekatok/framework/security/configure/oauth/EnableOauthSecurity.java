package icu.guokai.mekatok.framework.security.configure.oauth;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启基于OAith2服务器的登录认证
 * 需要授权服务器支持
 * @author GuoKai
 * @date 2021/8/18
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OauthSecurityConfiguration.class)
public @interface EnableOauthSecurity {
}
