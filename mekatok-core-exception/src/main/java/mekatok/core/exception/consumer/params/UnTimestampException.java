package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 非法的时间戳参数
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0414", message = "invalid timestamp parameter")
public class UnTimestampException extends RequiredException{

    public UnTimestampException() {
    }

    public UnTimestampException(String message) {
        super(message);
    }

    public UnTimestampException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnTimestampException(Throwable cause) {
        super(cause);
    }

    public UnTimestampException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
