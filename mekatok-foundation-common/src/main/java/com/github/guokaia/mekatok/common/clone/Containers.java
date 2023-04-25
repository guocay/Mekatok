package com.github.guokaia.mekatok.common.clone;

import cn.hutool.core.util.ReflectUtil;
import com.github.guokaia.mekatok.core.model.Packing;
import com.github.guokaia.mekatok.core.model.Require;

import java.lang.reflect.Field;

/**
 * 用于 容器对象的转换静态工具类
 * @author GuoKai
 * @date 2022/2/4
 */
public class Containers {

    private Containers(){}

    /**
     * 装箱 到一个已有对象
     * @param clazz 装箱后对象的类型
     * @param bean 装箱前对象数组
     * @param <T> 装箱后的泛型
     * @param <F> 装箱前的泛型
     * @return 装箱后的对象
     */
    public static <T extends Packing<T>, F extends Require> Packing<T> box(Class<T> clazz, F bean){
        return box(ReflectUtil.newInstance(clazz), bean);
    }

    /**
     * 装箱 到一个已有对象
     * @param packing 装箱后对象
     * @param bean 装箱前对象数组
     * @param <T> 装箱后的泛型
     * @param <F> 装箱前的泛型
     * @return 装箱后的对象
     */
    public static <T extends Packing<T>, F extends Require> Packing<T> box(T packing, F bean){
        Class<?> beanClass = bean.getClass();
        for(Field field : ReflectUtil.getFields(packing.getClass())){
            Conversion[] annotations = field.getAnnotationsByType(Conversion.class);
            for (Conversion definition : annotations){
                if(beanClass.isAssignableFrom(definition.clazz())){
                    ReflectUtil.setFieldValue(packing, field,
                        ReflectUtil.getFieldValue(bean, definition.field()));
                }
            }
        }
        return packing;
    }

}
