package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 网关 服务出错
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0154", message = "GateWay service error")
public class GateWayException extends NetworkServiceException{

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
