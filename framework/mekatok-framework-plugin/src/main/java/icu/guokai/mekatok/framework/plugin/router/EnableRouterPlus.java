package icu.guokai.mekatok.framework.plugin.router;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启router环绕通知和启动后打印映射
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({RouterInterceptor.class})
public @interface EnableRouterPlus {
}
