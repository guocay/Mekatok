package icu.guokai.mekatok.framework.core.asserts;

import icu.guokai.mekatok.framework.core.asserts.api.impl.*;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import icu.guokai.mekatok.framework.core.model.domain.View;
import icu.guokai.mekatok.framework.core.model.dto.Transport;

import java.io.File;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 用于实现断言功能的接口
 * @author GuoKai
 * @date 2021/10/6
 */
public interface WithAssertions {

    /**
     * 定义异常
     * @param clazz 异常类型
     * @param message 异常信息
     * @param <T> 泛型
     * @return 异常
     */
    default <T extends MekatokException> Supplier<T> exception(Class<T> clazz, String message){
        return Assertions.exception(clazz, message);
    }

    /**
     * 获取数组断言
     * @param objs 断言元数据
     * @param <T> 数据类型
     * @return 断言工具
     */
    default <T> ArrayAssert<T> assertThat(T... objs){
        return Assertions.assertThat(objs);
    }

    /**
     * 获取布尔断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    default BooleanAssert assertThat(Boolean obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 获取字符串断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    default <T extends CharSequence> CharSequenceAssert assertThat(T obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 获取java.util.Date断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    default <T extends Date> DateAssert assertThat(T obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 获取文件断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    default FileAssert assertThat(File obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 获取List集合断言
     * @param objs 断言元数据
     * @param <T> 数据类型
     * @return 断言工具
     */
    default <T> CollectionAssert<T> assertThat(Collection<T> objs){
        return Assertions.assertThat(objs);
    }

    /**
     * 获取 LocalDateTime 断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    default LocalDateTimeAssert assertThat(LocalDateTime obj){
        return Assertions.assertThat(obj);
    }
    /**
     * 获取Map集合断言
     * @param obj Map对象
     * @param <K> key类型
     * @param <V> value类型
     * @return 断言工具
     */
    default <K, V> MapAssert<K, V> assertThat(Map<K, V> obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 获取数字断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    default <T extends Number> NumberAssert<T> assertThat(T obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 获取对象断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    default <T> ObjectAssert<T> assertThat(T obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 基于Table对象的断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    default <T extends Table<?>> TableAssert<T> assertThat(T obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 基于View对象的断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    default <T extends View<?>> ViewAssert<T> assertThat(T obj){
        return Assertions.assertThat(obj);
    }

    /**
     * 基于Transport对象的断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    default <T extends Transport> TransportAssert<T> assertThat(T obj){
        return Assertions.assertThat(obj);
    }

}
