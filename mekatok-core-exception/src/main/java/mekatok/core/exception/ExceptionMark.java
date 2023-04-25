package mekatok.core.exception;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于定义异常编码
 * @author aCay
 * @since 2022/8/8
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionMark {

    /**
     * 异常编码
     * @return 异常编码
     */
    String code();

    /**
     * 异常描述
     * @return 异常描述
     */
    String message() default "";
}
