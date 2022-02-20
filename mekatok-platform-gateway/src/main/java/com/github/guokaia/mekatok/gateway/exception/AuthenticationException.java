package com.github.guokaia.mekatok.gateway.exception;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * 用户认证失败异常
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/20
 */
@ExceptionDefinition(code = "M-AUTH-001", message = "用户认证失败")
public class AuthenticationException extends MekatokException {
    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    public AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
