package icu.guokai.mekatok.framework.core.asserts.api;

import icu.guokai.mekatok.framework.core.asserts.exception.AssertionsException;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import lombok.NonNull;

import java.util.function.Supplier;

/**
 * 用于定义所有断言接口的基类
 * 模仿 assertJ 流式断言机制实现的业务级断言工具
 * @author GuoKai
 * @date 2021/10/6
 */
@SuppressWarnings("all")
public abstract class Assert<S extends Assert<S, A>, A> {

    /**
     * 用于存储断言工具类需要抛出的异常
     */
    private Supplier<? extends MekatokException> exInfo = () -> new AssertionsException("Data Assertion Failed!");

    /**
     * 待断言对象
     */
    protected final A actual;

    /**
     * 返回当前对象
     * @return 断言工具类
     */
    protected S self(){
        return (S) this;
    }

    /**
     * 抛出异常
     */
    protected void exception(){
        throw exInfo.get();
    }

    /**
     * 抛出异常
     * @param success 断言是否成功
     */
    protected S exception(Boolean success){
        if(!success) exception();
        return self();
    }

    /**
     * 构造器
     * @param actual 待断言对象
     */
    public Assert(@NonNull A actual) {
        this.actual = actual;
    }

    /**
     * 装载 自定义异常
     * @param supplier 异常信息
     * @param <T> 泛型
     * @return 断言工具
     */
    public <T extends MekatokException> S as(Supplier<T> supplier){
        this.exInfo = supplier;
        return self();
    }

    /**
     * 判断是空
     * @return 断言工具
     */
    public S isNull(){
        return exception(actual == null);
    }

    /**
     * 判断非空
     * @return 断言工具
     */
    public S isNotNull(){
        return exception(actual != null);
    }

    /**
     * 是否
     * @param obj
     * @return 是否
     */
    abstract public S is(A obj);

}
