package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 网络 服务异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0150", message = "Network service exception")
public class NetworkServiceException extends MiddlewareException{

    public NetworkServiceException() {
    }

    public NetworkServiceException(String message) {
        super(message);
    }

    public NetworkServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkServiceException(Throwable cause) {
        super(cause);
    }

    public NetworkServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
