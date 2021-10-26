package icu.guokai.mekatok.framework.core.asserts;

import cn.hutool.core.util.ReflectUtil;
import icu.guokai.mekatok.framework.core.asserts.api.impl.*;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import icu.guokai.mekatok.framework.core.model.domain.View;
import icu.guokai.mekatok.framework.core.model.dto.Transport;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 断言功能静态工具类
 * @author GuoKai
 * @date 2021/10/6
 */
public abstract class Assertions {

    /**
     * 定义异常
     * @param clazz 异常类型
     * @param message 异常信息
     * @param <T> 泛型
     * @return 异常
     */
    public static <T extends MekatokException> Supplier<T> exception(Class<T> clazz, String message){
        return () -> ReflectUtil.newInstance(clazz, message);
    }

    /**
     * 获取数组断言
     * @param objs 断言元数据
     * @param <T> 数据类型
     * @return 断言工具
     */
    public static <T> ArrayAssert<T> assertThat(T... objs){
        return new ArrayAssert<T>(objs);
    }

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
    public static  DateAssert assertThat(Date obj){
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
     * 基于Table对象的断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends Table<?>> TableAssert<T> assertThat(T obj){
        return new TableAssert<T>(obj);
    }

    /**
     * 基于View对象的断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends View<?>> ViewAssert<T> assertThat(T obj){
        return new ViewAssert<T>(obj);
    }

    /**
     * 基于Transport对象的断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends Transport> TransportAssert<T> assertThat(T obj){
        return new TransportAssert<T>(obj);
    }
}
