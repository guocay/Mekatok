package mekatok.core.assertion;

/**
 * 实例类别断言器
 * @author aCay
 * @since 2023.04.17
 */
public class InstanceOfAssertion<T> extends AbstractAssertion<InstanceOfAssertion<T>, Class<T>> {

	public InstanceOfAssertion(Class<T> actual, boolean nullable) {
		super(actual, nullable);
	}

	/**
	 * 判断是否属于类
	 * @param obj 待断言类
	 * @return 断言器
	 */
	public InstanceOfAssertion<T> match(T obj){
		if (!actual.isInstance(obj))
			throwException();
		return self();
	}

	/**
	 * 判断是否属于子类
	 * @param obj 待断言类
	 * @return 断言器
	 */
	public InstanceOfAssertion<T> progeny(T obj){
		if (obj != null && !obj.getClass().isAssignableFrom(actual))
			throwException();
		return self();
	}

}
