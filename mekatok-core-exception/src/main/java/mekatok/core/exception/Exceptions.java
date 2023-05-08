package mekatok.core.exception;

import mekatok.core.component.exception.PlatformException;

import java.util.Objects;
import java.util.Optional;

/**
 * 异常 相关工具类
 * @author GuoCay
 * @since 2022/8/8
 */
public abstract class Exceptions {

    /**
     * 获取异常编码
     * @param exClass 异常类
     * @return 异常编码
     * @param <T> 异常泛型
     */
    public static <T extends PlatformException> Optional<String> getCode(Class<T> exClass){
        if (Objects.equals(exClass, PlatformException.class))
            return Optional.empty();
        return Optional.of(exClass.getAnnotation(ExceptionMark.class).code());
    }

    /**
     * 获取异常编码
     * @param exClass 异常类
     * @param defaultValue 默认值
     * @return 异常编码
     * @param <T> 异常泛型
     */
    public static <T extends PlatformException> String getCode(Class<T> exClass, String defaultValue){
        return getCode(exClass).orElse(defaultValue);
    }

    /**
     * 获取异常描述
     * @param exClass 异常类
     * @return 异常编码
     * @param <T> 异常泛型
     */
    public static <T extends PlatformException> Optional<String> getMessage(Class<T> exClass){
        if (Objects.equals(exClass, PlatformException.class))
            return Optional.empty();
        return Optional.of(exClass.getAnnotation(ExceptionMark.class).message());
    }
    /**
     * 获取异常描述
     * @param exClass 异常类
     * @return 异常编码
     * @param defaultValue 默认值
     * @param <T> 异常泛型
     */
    public static <T extends PlatformException> String getMessage(Class<T> exClass, String defaultValue){
        return getMessage(exClass).orElse(defaultValue);
    }

}
