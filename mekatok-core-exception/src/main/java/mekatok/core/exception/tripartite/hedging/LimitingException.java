package mekatok.core.exception.tripartite.hedging;

import mekatok.core.exception.ExceptionMark;

/**
 * 第三方限流策略被触发
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0401", message = "Third-party current limiting policy is triggered")
public class LimitingException extends HedgingException {

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
