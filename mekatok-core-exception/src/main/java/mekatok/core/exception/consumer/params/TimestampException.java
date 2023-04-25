package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 缺少时间戳参数
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0413", message = "Missing timestamp parameter")
public class TimestampException extends RequiredException{

    public TimestampException() {
    }

    public TimestampException(String message) {
        super(message);
    }

    public TimestampException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimestampException(Throwable cause) {
        super(cause);
    }

    public TimestampException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
