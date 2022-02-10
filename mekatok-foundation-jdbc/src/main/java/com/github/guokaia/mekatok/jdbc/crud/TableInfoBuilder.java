package com.github.guokaia.mekatok.jdbc.crud;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.github.guokaia.mekatok.common.foreign.Exceptions;
import com.github.guokaia.mekatok.core.model.store.Table;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * 根据 id 和 实现时指定的泛型.创建对象.
 * @author GuoKai
 * @date 2022/2/4
 */
public interface TableInfoBuilder<T extends Table<T>> {

    /**
     * 构建当前对象实体
     * @param id 主键
     * @return 实例
     */
    default T creation(String id){
        // 获取当前接口的 实现类 在实现这个接口时所指定的泛型
        Class<T> first = Arrays.stream(getClass().getGenericInterfaces()).map(Type::getTypeName)
            .filter(item -> TableInfoBuilder.class.isAssignableFrom(ClassUtil.loadClass(item.substring(0,item.indexOf("<")))))
            .map(item -> ClassUtil.<T>loadClass(item.substring(item.indexOf("<") + 1,item.indexOf(">"))))
            .findFirst().orElseThrow(Exceptions.ex("对象无法被实例化"));
        // 构建当前对象
        return ReflectUtil.newInstance(first).setId(id);
    }
}
