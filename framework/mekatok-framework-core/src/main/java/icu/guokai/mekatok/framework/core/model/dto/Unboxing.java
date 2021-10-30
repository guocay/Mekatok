package icu.guokai.mekatok.framework.core.model.dto;

import icu.guokai.mekatok.framework.core.model.domain.View;

import java.lang.annotation.*;

/**
 * 数据传输对象拆箱时的属性指定
 * @author GuoKai
 * @date 2021/9/28
 */
@Documented
@Target(ElementType.FIELD)
@Repeatable(Unboxing.List.class)
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("all")
public @interface Unboxing {

    /**
     * 用于指定装箱的数据传输类
     * @return 装箱的类
     */
    Class<? extends View> clazz();

    /**
     * 用于指定类中的字段
     * @return 类中的字段名
     */
    String field();

    @Documented
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        Unboxing[] value();
    }
}
