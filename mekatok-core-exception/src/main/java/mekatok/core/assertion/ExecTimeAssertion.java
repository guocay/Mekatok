package mekatok.core.assertion;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * 超执行时间断言类
 * @author aCay
 * @since 2023.04.17
 */
public class ExecTimeAssertion<T> extends AbstractAssertion<ExecTimeAssertion<T>, Supplier<T>> {

	/**
	 * 用于记录执行时间
	 */
	private Long executionTime = -1L;

	public ExecTimeAssertion(Supplier<T> actual, boolean nullable) {
		super(actual, nullable);
	}

	/**
	 * 大于
	 * @param duration 时间
	 * @return 断言类
	 */
	public ExecTimeAssertion<T> gt(Duration duration){
		if (duration.toMillis() > getExecutionTime())
			throwException();
		return self();
	}

	/**
	 * 大于等于
	 * @param duration 时间
	 * @return 断言类
	 */
	public ExecTimeAssertion<T> ge(Duration duration){
		if (duration.toMillis() >= getExecutionTime())
			throwException();
		return self();
	}

	/**
	 * 小于
	 * @param duration 时间
	 * @return 断言类
	 */
	public ExecTimeAssertion<T> lt(Duration duration){
		if (duration.toMillis() < getExecutionTime())
			throwException();
		return self();
	}

	/**
	 * 小于等于
	 * @param duration 时间
	 * @return 断言类
	 */
	public ExecTimeAssertion<T> le(Duration duration){
		if (duration.toMillis() <= getExecutionTime())
			throwException();
		return self();
	}


	/**
	 * 等于
	 * @param duration 时间
	 * @return 断言类
	 */
	public ExecTimeAssertion<T> eq(Duration duration){
		if (duration.toMillis() == getExecutionTime())
			throwException();
		return self();
	}

	/**
	 * 获取执行时间
	 * @return 执行毫秒数
	 */
	private long getExecutionTime() {
		if (executionTime < 0L)
			execution();
		return executionTime;
	}

	/**
	 * 执行任务
	 */
	private void execution() {
		long currentTimeMillis = System.currentTimeMillis();
		if (actual.get() instanceof Future<?> future){
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		}
		executionTime = System.currentTimeMillis() - currentTimeMillis;
	}

}
