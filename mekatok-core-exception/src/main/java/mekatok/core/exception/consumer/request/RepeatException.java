package mekatok.core.exception.consumer.request;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户重复请求
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0506", message = "User repeated request")
public class RepeatException extends RequestException{
    public RepeatException() {
    }

    public RepeatException(String message) {
        super(message);
    }

    public RepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatException(Throwable cause) {
        super(cause);
    }

    public RepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
