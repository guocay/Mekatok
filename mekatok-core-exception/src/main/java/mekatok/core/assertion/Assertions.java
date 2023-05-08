package mekatok.core.assertion;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 断言工具类
 * @author GuoCay
 * @since 2023.03.10
 */
public abstract class Assertions {

    /**
     * 获取布尔断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static BooleanAssertion assertThat(Boolean obj){
        return assertThat(obj, false);
    }

	/**
	 * 获取布尔断言
	 * @param obj 断言元数据
	 * @param nullable 可以为空
	 * @return 断言工具
	 */
	public static BooleanAssertion assertThat(Boolean obj, boolean nullable){
		return new BooleanAssertion(obj, nullable);
	}

    /**
     * 获取字符,字符串断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static StringAssertion assertThat(String obj){
        return assertThat(obj, false);
    }

	/**
	 * 获取布尔断言
	 * @param obj 断言元数据
	 * @param nullable 可以为空
	 * @return 断言工具
	 */
	public static StringAssertion assertThat(String obj, boolean nullable){
		return new StringAssertion(obj, nullable);
	}

    /**
     * 获取List集合断言
     * @param objs 断言元数据
     * @param <T> 数据类型
     * @return 断言工具
     */
    public static <T> ListAssertion<T> assertThat(List<T> objs){
        return assertThat(objs, false);
    }

	/**
	 * 获取List集合断言
	 * @param objs 断言元数据
	 * @param nullable 可以为空
	 * @param <T> 数据类型
	 * @return 断言工具
	 */
	public static <T> ListAssertion<T> assertThat(List<T> objs, boolean nullable){
		return new ListAssertion<>(objs, nullable);
	}

    /**
     * 获取数字断言
     * @param obj 断言元数据
     * @param <T> 泛型
     * @return 断言工具
     */
    public static <T extends Number> NumberAssertion<T> assertThat(T obj){
        return assertThat(obj, false);
    }

	/**
	 * 获取数字断言
	 * @param obj 断言元数据
	 * @param nullable 可以为空
	 * @param <T> 泛型
	 * @return 断言工具
	 */
	public static <T extends Number> NumberAssertion<T> assertThat(T obj, boolean nullable){
		return new NumberAssertion<>(obj, nullable);
	}

    /**
     * 获取Map集合断言
     * @param obj Map对象
     * @param <K> key类型
     * @param <V> value类型
     * @return 断言工具
     */
    public static <K, V> MapAssertion<K, V> assertThat(Map<K, V> obj){
        return assertThat(obj, false);
    }

	/**
	 * 获取Map集合断言
	 * @param obj Map对象
	 * @param nullable 可以为空
	 * @param <K> key类型
	 * @param <V> value类型
	 * @return 断言工具
	 */
	public static <K, V> MapAssertion<K, V> assertThat(Map<K, V> obj, boolean nullable){
		return new MapAssertion<>(obj, nullable);
	}

    /**
     * 获取 LocalDateTime 断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static NewTimeApiAssertion assertThat(LocalDateTime obj){
        return assertThat(obj, false);
    }

	/**
	 * 获取 LocalDateTime 断言
	 * @param obj 断言元数据
	 * @param nullable 可以为空
	 * @return 断言工具
	 */
	public static NewTimeApiAssertion assertThat(LocalDateTime obj, boolean nullable){
		return new NewTimeApiAssertion(obj, nullable);
	}

    /**
     * 获取文件断言
     * @param obj 断言元数据
     * @return 断言工具
     */
    public static FileAssertion assertThat(File obj){
        return assertThat(obj, false);
    }

	/**
	 * 获取文件断言
	 * @param obj 断言元数据
	 * @param nullable 可以为空
	 * @return 断言工具
	 */
	public static FileAssertion assertThat(File obj, boolean nullable){
		return new FileAssertion(obj, nullable);
	}

	/**
	 * 获取任务执行时间断言
	 * @param supplier 断言的任务
	 * @return 断言工具
	 */
	public static <T> ExecTimeAssertion<T> assertThat(Supplier<T> supplier){
		return assertThat(supplier, false);
	}

	/**
	 * 获取任务执行时间断言
	 * @param supplier 断言的任务
	 * @param nullable 可以为空
	 * @return 断言工具
	 */
	public static <T> ExecTimeAssertion<T> assertThat(Supplier<T> supplier, boolean nullable){
		return new ExecTimeAssertion<>(supplier, nullable);
	}

	/**
	 * 获取实例类型断言
	 * @param clazz 断言的任务
	 * @return 断言工具
	 */
	public static <T> InstanceOfAssertion<T> assertThat(Class<T> clazz){
		return assertThat(clazz, false);
	}

	/**
	 * 获取实例类型断言
	 * @param clazz 断言的任务
	 * @param nullable 可以为空
	 * @return 断言工具
	 */
	public static <T> InstanceOfAssertion<T> assertThat(Class<T> clazz, boolean nullable){
		return new InstanceOfAssertion<>(clazz, nullable);
	}

}
