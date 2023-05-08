package mekatok.core.assertion;

/**
 * 数字 断言工具类
 * @author GuoCay
 * @since 2023.03.10
 */
public class NumberAssertion<T extends Number> extends AbstractAssertion<NumberAssertion<T>, T>{

    /**
     * 数字副本
     */
    private final Double duplication;

    public NumberAssertion(T actual, boolean nullable) {
        super(actual, nullable);
        duplication = actual.doubleValue();
    }

    /**
     * 小于
     * @param obj 长度
     * @return 断言工具
     */
    public NumberAssertion<T> lt(T obj){
        if (duplication >= obj.doubleValue())
            throwException();
        return self();
    }

    /**
     * 小于等于
     * @param obj 长度
     * @return 断言工具
     */
    public NumberAssertion<T> le(T obj){
        if (duplication > obj.doubleValue())
            throwException();
        return self();
    }

    /**
     * 大于
     * @param obj 长度
     * @return 断言工具
     */
    public NumberAssertion<T> gt(T obj){
        if (duplication <= obj.doubleValue())
            throwException();
        return self();
    }

    /**
     * 大于等于
     * @param obj 长度
     * @return 断言工具
     */
    public NumberAssertion<T> ge(T obj){
        if (duplication < obj.doubleValue())
            throwException();
        return self();
    }

    /**
     * 不等于
     * @param obj 长度
     * @return 断言工具
     */
    public NumberAssertion<T> ne(T obj){
        if (duplication == obj.doubleValue())
            throwException();
        return self();
    }
}
