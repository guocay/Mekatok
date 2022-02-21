package com.github.guokaia.mekatok.context.exception;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * 幂等异常
 * @author GuoKai
 * @date 2022/2/20
 */
@ExceptionDefinition(code = "M-IDEMPOTENT-001", message = "触发服务幂等拦截")
public class IdempotentException extends MekatokException {
    public IdempotentException() {
        super();
    }

    public IdempotentException(String message) {
        super(message);
    }

    public IdempotentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdempotentException(Throwable cause) {
        super(cause);
    }

    public IdempotentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
