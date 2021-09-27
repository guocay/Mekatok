package icu.guokai.mekatok.framework.flowable.configure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启自定义配置 Flowable
 * @author GuoKai
 * @date 2021/8/30
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({FlowableConfiguration.class})
public @interface EnableCustomFlowable {
}
