package com.github.guokaia.mekatok.common.foreign;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;
import com.github.guokaia.mekatok.core.lambda.Runner;
import com.github.guokaia.mekatok.core.lambda.Supplier;

import java.util.Objects;
import java.util.function.Function;

/**
 * 异常操作工具类
 * @author GuoKai
 * @date 2022/1/27
 */
@SuppressWarnings("all")
public class Exceptions {

    /**
     * 私有化构造器
     */
    private Exceptions(){}

    /**
     * 定义异常
     * @param clazz 异常类型
     * @param <T> 泛型
     * @return 异常
     */
    public static <T extends MekatokException> java.util.function.Supplier<T> ex(Class<T> clazz){
        return ex(clazz, "");
    }


    /**
     * 定义异常
     * @param message 异常信息
     * @return 异常
     */
    public static java.util.function.Supplier<MekatokException> ex(String message){
        return ex(MekatokException.class, message);
    }

    /**
     * 定义异常
     * @param clazz 异常类型
     * @param message 异常信息
     * @param <T> 泛型
     * @return 异常
     */
    public static <T extends MekatokException> java.util.function.Supplier<T> ex(Class<T> clazz, String message){
        return () -> ReflectUtil.newInstance(clazz, message);
    }

    /**
     * 静态构建函数
     * @param clazz
     * @param <Exception>
     * @return
     */
    public static <Exception extends MekatokException> Exception create(Class<Exception> clazz){
        return create(clazz, null);
    }

    /**
     * 创建异常对象
     * @param clazz 异常类型
     * @param message 异常消息
     * @param <Exception> 泛型
     * @return 异常对象
     */
    public static <Exception extends MekatokException> Exception create(Class<Exception> clazz, String message){
        ExceptionDefinition ex;
        if (StrUtil.isBlank(message) && Objects.nonNull(ex = clazz.getAnnotation(ExceptionDefinition.class))){
            message = ex.message();
        }
        return ReflectUtil.newInstance(clazz, message);
    }

    /**
     * 用于包装异常的执行
     * @param runner 需要执行的代码
     */
    public static void run(Runner runner){
        run(runner, (throwable) -> create(MekatokException.class, throwable.getMessage()));
    }

    /**
     * 用于包装异常的执行
     * @param runner 需要执行的代码
     * @param fun 处理异常
     * @param <T> 执行代码抛出的异常
     * @param <R> 包装的异常
     */
    public static <T extends Throwable,R extends MekatokException> void run(Runner runner, Function<T,R> fun){
        try {
            runner.run();
        }catch (Throwable throwable){
            throw fun.apply((T) throwable);
        }
    }

    /**
     * 用于包装异常的执行
     * @param supplier 需要执行的代码
     * @param <T> 返回的类型
     * @return 返回的对象
     */
    public static <T extends Object> T run(Supplier<T> supplier){
        return run(supplier, (throwable) -> create(MekatokException.class, throwable.getMessage()));
    }

    /**
     * 用于包装异常的执行
     * @param supplier 需要执行的代码
     * @param <T> 返回的类型
     * @param <V> 执行代码抛出的异常
     * @param <O> 包装的异常
     * @return 返回的对象
     */
    public static <T extends Object, V extends Throwable, O extends MekatokException> T run(Supplier<T> supplier, Function<V,O> fun){
        try {
            return supplier.get();
        }catch (Throwable throwable){
            throw fun.apply((V) throwable);
        }
    }

}
