package icu.guokai.mekatok.framework.plugin.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启SpringUtil支持,区别于hutool包中的 EnableSpringUtil.
 * 那个好像没用.@import导入不了@Component注解的bean
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SpringConfig.class)
public @interface EnableSpring {
}
