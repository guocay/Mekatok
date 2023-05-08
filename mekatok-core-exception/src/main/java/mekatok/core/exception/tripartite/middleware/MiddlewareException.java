package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.tripartite.TripartiteException;

/**
 * 中间件服务出错
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0100", message = "middleware service error")
public class MiddlewareException extends TripartiteException {

    public MiddlewareException() {
    }

    public MiddlewareException(String message) {
        super(message);
    }

    public MiddlewareException(String message, Throwable cause) {
        super(message, cause);
    }

    public MiddlewareException(Throwable cause) {
        super(cause);
    }

    public MiddlewareException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
