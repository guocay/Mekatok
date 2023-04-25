package icu.guokai.mekatok.framework.plugin.liteflow;

import icu.guokai.mekatok.framework.plugin.liteflow.property.Property;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 用于开启 LiteFlow 配置
 * @author GuoKai
 * @date 2021/10/30
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LiteflowEngineConfig.class)
@EnableConfigurationProperties(Property.class)
public @interface EnableLiteFlow {
}
