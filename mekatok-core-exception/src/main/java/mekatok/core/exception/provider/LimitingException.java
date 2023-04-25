package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 限流策略被触发
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0210", message = "The current limiting strategy is triggered")
public class LimitingException extends HedgingException{

    public LimitingException() {
    }

    public LimitingException(String message) {
        super(message);
    }

    public LimitingException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitingException(Throwable cause) {
        super(cause);
    }

    public LimitingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
