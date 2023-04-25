package icu.guokai.mekatok.framework.plugin.swagger;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启Swagger配置类
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({SwaggerConfig.class})
public @interface EnableSwagger {
}
