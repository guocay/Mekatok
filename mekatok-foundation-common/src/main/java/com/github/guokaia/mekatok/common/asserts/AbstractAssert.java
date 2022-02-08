package com.github.guokaia.mekatok.common.asserts;

import com.github.guokaia.mekatok.core.exception.MekatokException;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 用于定义所有断言接口的基类
 * 模仿 assertJ 流式断言机制实现的业务级断言工具
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
public abstract class AbstractAssert<S extends AbstractAssert<S, A>, A> {

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
    public AbstractAssert(A actual) {
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
        return exception(Objects.isNull(actual));
    }

    /**
     * 判断非空
     * @return 断言工具
     */
    public S isNotNull(){
        return exception(Objects.nonNull(actual));
    }

    /**
     * 是否
     * @param obj
     * @return 是否
     */
    abstract public S is(A obj);

}
