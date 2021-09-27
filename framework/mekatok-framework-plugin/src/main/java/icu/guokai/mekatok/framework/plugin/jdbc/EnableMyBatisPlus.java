package icu.guokai.mekatok.framework.plugin.jdbc;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 MybatisPlus 设置
 * @author GuoKai
 * @date 2021/8/13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyBatisPlusConfig.class)
public @interface EnableMyBatisPlus {
}
