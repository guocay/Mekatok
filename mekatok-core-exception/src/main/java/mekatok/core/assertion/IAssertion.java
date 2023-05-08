package mekatok.core.assertion;

import mekatok.core.component.exception.PlatformException;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 断言类 接口
 * @author GuoCay
 * @since 2023.03.10
 */
public interface IAssertion<S,A> {

	/**
	 * 直接失败
	 */
	void fail();

	/**
	 * 直接失败
	 * @param message 异常文本
	 */
	void fail(String message);

	/**
	 * 直接失败
	 * @param exception 异常信息
	 */
	void fail(PlatformException exception);

    /**
     * 修改 断言失败后抛出的异常
     * @param supplier 获取异常
     * @return 断言器
     */
    S as(Supplier<PlatformException> supplier);

    /**
     * 是否 非空
     * @return 断言器
     */
    S nonNull();

    /**
     * 是否 双等于判断
     * @param snapshot 快照
     * @return 断言器
     */
    S is(A snapshot);

    /**
     * 通过默认的构造器比对
     * @param obj 对象
     * @return 断言器
     */
    default S equalsByDefault(A obj) {
        return equals(obj, null);
    }

    /**
     * 通过默认的构造器比对
     * @param obj 对象
     * @param customEquals 自定义比对器
     * @return 断言器
     */
    S equals(A obj, BiFunction<A, A, Boolean> customEquals);

    /**
     * 判断一个对象是不是数组类型
     * @return 断言器
     */
    S isArray();

    /**
     * 判断是否为子类
     * @param clazz 类型
     * @return 断言器
     */
    S isAssignableFrom(Class<A> clazz);

    /**
     * 判断条件是否成立, 返回 false则抛出异常
     * @param predicate 条件
     * @return 断言器
     */
    S predicate(Predicate<A> predicate);

}
