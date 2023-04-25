package com.github.guokaia.mekatok.common.clone;

import com.github.guokaia.mekatok.core.model.Packing;

import java.lang.annotation.*;

/**
 * 设置转换类的定义
 * @author GuoKai
 * @date 2022/2/4
 */
@Documented
@Target(ElementType.FIELD)
@Repeatable(Conversion.List.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Conversion {

    /**
     * 用于指定装箱的数据传输类
     * @return 装箱的类
     */
    Class<? extends Packing<?>> clazz();

    /**
     * 用于指定类中的字段
     * @return 类中的字段名
     */
    String field();

    @Documented
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        Conversion[] value();
    }
}
