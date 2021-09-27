package icu.guokai.mekatok.framework.core.function;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;

import java.util.function.Supplier;

/**
 * 用于自定义定义断言的lambda接口
 * @author GuoKai
 * @date 2021/8/5
 */
@FunctionalInterface
public interface MistakeSupplier<T extends MekatokException> extends Supplier<T> {

}
