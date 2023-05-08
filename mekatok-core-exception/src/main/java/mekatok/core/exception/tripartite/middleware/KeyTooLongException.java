package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * key 长度超过限制
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0131", message = "key length exceeds the limit")
public class KeyTooLongException extends CacheServiceException{

    public KeyTooLongException() {
    }

    public KeyTooLongException(String message) {
        super(message);
    }

    public KeyTooLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyTooLongException(Throwable cause) {
        super(cause);
    }

    public KeyTooLongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
