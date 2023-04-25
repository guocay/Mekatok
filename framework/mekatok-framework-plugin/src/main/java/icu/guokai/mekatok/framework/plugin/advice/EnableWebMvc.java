package icu.guokai.mekatok.framework.plugin.advice;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启控制器环绕通知
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({WebMvcExceptionAdvice.class})
public @interface EnableWebMvc {
}
