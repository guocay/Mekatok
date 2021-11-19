package icu.guokai.mekatok.framework.plugin.json;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 json format 序列化
 * @author GuoKai
 * @date 2021/11/19
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({JsonFormatConfig.class})
public @interface EnableJsonFormat {
}
