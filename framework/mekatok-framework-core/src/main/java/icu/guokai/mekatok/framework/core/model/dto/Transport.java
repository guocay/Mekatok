package icu.guokai.mekatok.framework.core.model.dto;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ReflectUtil;
import icu.guokai.mekatok.framework.core.model.Model;
import icu.guokai.mekatok.framework.core.model.domain.View;

import java.util.Arrays;

/**
 * 数据传输对象基类
 * @author GuoKai
 * @date 2021/9/28
 */
@SuppressWarnings("all")
public interface Transport extends Model {

    /**
     * 用于数据传输对象的拆箱
     * @param <T> 拆箱后的类型
     * @return 拆箱后的对象
     */
    default <T extends View> T unBoxing(Class<T> clazz){
        T view = ReflectUtil.newInstance(clazz);
        // todo 循环获取当前类的字段
        Arrays.stream(ReflectUtil.getFields(getClass())).parallel()
                // todo 过滤出需要拆箱的字段
                .filter(field -> AnnotationUtil.hasAnnotation(field,Unboxing.class))
                .forEach(field -> {
                    // todo 获取字段中所有 Unboxing 描述信息
                    Arrays.stream(field.getAnnotationsByType(Unboxing.class)).parallel()
                            // todo 过滤出需要转换的类
                            .filter(anno -> clazz.isAssignableFrom(anno.clazz()))
                            .forEach(anno -> {
                                var viewField = ReflectUtil.getField(clazz, anno.field());
                                // todo 设置字段反射,绕过权限校验
                                field.setAccessible(true);
                                viewField.setAccessible(true);
                                // todo 设置值
                                ReflectUtil.setFieldValue(view, viewField, ReflectUtil.getFieldValue(this, field));
                            });
                });
        return view;
    }
}
