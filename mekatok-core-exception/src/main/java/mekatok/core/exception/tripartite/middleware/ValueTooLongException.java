package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * key 长度超过限制
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0132", message = "value length exceeds the limit")
public class ValueTooLongException extends CacheServiceException{

    public ValueTooLongException() {
    }

    public ValueTooLongException(String message) {
        super(message);
    }

    public ValueTooLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValueTooLongException(Throwable cause) {
        super(cause);
    }

    public ValueTooLongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
