package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 缓存 服务异常
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0130", message = "Cache service exception")
public class CacheServiceException extends MiddlewareException{

    public CacheServiceException() {
    }

    public CacheServiceException(String message) {
        super(message);
    }

    public CacheServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheServiceException(Throwable cause) {
        super(cause);
    }

    public CacheServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
