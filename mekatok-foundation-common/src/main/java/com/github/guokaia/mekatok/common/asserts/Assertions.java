package com.github.guokaia.mekatok.common.asserts;

import com.github.guokaia.mekatok.common.asserts.impl.*;
import com.github.guokaia.mekatok.core.model.Require;
import com.github.guokaia.mekatok.core.model.store.Table;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 断言功能静态工具类
 * @author GuoKai
 * @date 2022/2/1
 */
public class Assertions {

    private Assertions(){}

    /**
     * 获取布尔断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static BooleanAssert assertThat(Boolean obj){
        return new BooleanAssert(obj);
    }

    /**
     * 获取字符,字符串断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static CharSequenceAssert assertThat(CharSequence obj){
        return new CharSequenceAssert(obj);
    }

    /**
     * 获取java.util.Date断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static DateAssert assertThat(Date obj){
        return new DateAssert(obj);
    }

    /**
     * 获取文件断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static FileAssert assertThat(File obj){
        return new FileAssert(obj);
    }

    /**
     * 获取List集合断言
     * @param objs 断言元数据
     * @param <T> 数据类型
     * @return 断言工具
     */
    public static <T> CollectionAssert<T> assertThat(Collection<T> objs){
        return new CollectionAssert<T>(objs);
    }

    /**
     * 获取 LocalDateTime 断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static LocalDateTimeAssert assertThat(LocalDateTime obj){
        return new LocalDateTimeAssert(obj);
    }

    /**
     * 获取Map集合断言
     * @param obj Map对象
     * @param <K> key类型
     * @param <V> value类型
     * @return 断言工具
     */
    public static <K, V> MapAssert<K, V> assertThat(Map<K, V> obj){
        return new MapAssert<K, V>(obj);
    }

    /**
     * 获取数字断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends Number> NumberAssert<T> assertThat(T obj){
        return new NumberAssert<T>(obj);
    }

    /**
     * 获取对象断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T> ObjectAssert<T> assertThat(T obj){
        return new ObjectAssert<T>(obj);
    }

    /**
     * 获取表格断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends Table<T>> TableAssert<T> assertThat(T obj){
        return new TableAssert<T>(obj);
    }

    /**
     * 获取请求断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends Require> RequireAssert<T> assertThat(T obj){
        return new RequireAssert<T>(obj);
    }

}
