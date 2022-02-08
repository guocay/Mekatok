package com.github.guokaia.mekatok.gateway.exception;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * 自定义网关异常
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
@ExceptionDefinition(code = "M-GATEWAY-001",message = "网关路由异常")
public class GateWayException extends MekatokException {

    public GateWayException() {
    }

    public GateWayException(String message) {
        super(message);
    }

    public GateWayException(String message, Throwable cause) {
        super(message, cause);
    }

    public GateWayException(Throwable cause) {
        super(cause);
    }

    public GateWayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
