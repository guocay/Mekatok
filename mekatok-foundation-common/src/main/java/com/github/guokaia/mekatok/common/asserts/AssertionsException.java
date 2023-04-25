package com.github.guokaia.mekatok.common.asserts;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * 业务断言的基础类
 * @author GuoKai
 * @date 2022/2/1
 */
@ExceptionDefinition(code = "M-ASSERTION-0001", message = "业务断言异常")
public class AssertionsException extends MekatokException {
    public AssertionsException() {
    }

    public AssertionsException(String message) {
        super(message);
    }

    public AssertionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsException(Throwable cause) {
        super(cause);
    }

    public AssertionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
