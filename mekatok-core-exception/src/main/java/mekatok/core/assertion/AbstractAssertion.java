package mekatok.core.assertion;

import mekatok.core.component.exception.PlatformException;
import mekatok.core.exception.AssertionException;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 抽象的断言对象
 * @author GuoCay
 * @since 2023.03.10
 */
public class AbstractAssertion<S extends AbstractAssertion<S, A>, A> implements IAssertion<S,A> {

    /**
     * 用于存储断言工具类需要抛出的异常
     */
    private Supplier<? extends PlatformException> supplier = AssertionException::new;

    /**
     * 待断言对象
     */
    protected final A actual;

    AbstractAssertion(A actual, boolean nullable){
        this.actual = actual;
        // 判断这个待断言对象不得为空.
        if (!nullable)
            nonNull();
    }

    /**
     * 返回本身
     * @return 本身
     */
    @SuppressWarnings("unchecked")
    S self(){
        return (S) this;
    }

    /**
     * 抛出异常
     */
    void throwException(){
        throwException(supplier.get());
    }

	/**
	 * 抛出异常
	 * @param exception 异常信息
	 */
	void throwException(PlatformException exception){
		throw exception;
	}

	@Override
	public void fail() {
		fail((String) null);
	}

	@Override
	public void fail(String message) {
		fail(new AssertionException(message));
	}

	@Override
	public void fail(PlatformException exception) {
		throwException(exception);
	}

	@Override
    public S as(Supplier<PlatformException> supplier) {
        this.supplier = supplier;
        return self();
    }

    @Override
    public S nonNull() {
        return predicate(Objects::nonNull);
    }

    @Override
    public S is(A snapshot) {
        if (snapshot != actual)
            throwException();
        return self();
    }

    @Override
    public S equals(A obj, BiFunction<A, A, Boolean> customEquals) {
        // 这里是两个判断依次进行,
        // 先判断自定义的比对器是否为空, 为空则用actual的equals函数比较.
        // 如果自定义的比对器不为空, 则使用自定义比对器比对.
        if ((Objects.isNull(customEquals) && !actual.equals(obj)) || !customEquals.apply(actual, obj))
            throwException();
        return self();
    }

    @Override
    public S predicate(Predicate<A> predicate) {
        if (!predicate.test(actual))
            throwException();
        return self();
    }

    @Override
    public S isArray(){
        if (!actual.getClass().isArray())
            throwException();
        return self();
    }

    @Override
    public S isAssignableFrom(Class<A> clazz) {
        if (!actual.getClass().isAssignableFrom(clazz))
            throwException();
        return self();
    }
}
