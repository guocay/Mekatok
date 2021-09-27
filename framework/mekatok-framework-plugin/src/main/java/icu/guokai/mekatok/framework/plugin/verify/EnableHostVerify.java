package icu.guokai.mekatok.framework.plugin.verify;

import icu.guokai.mekatok.framework.plugin.verify.property.Property;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启主机校验
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(Property.class)
@Import({AppClientVerify.class, AppStartUpVerify.class})
public @interface EnableHostVerify { }
