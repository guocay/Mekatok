package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 降级策略被触发
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0220", message = "The downgrade strategy is triggered")
public class DowngradeException extends HedgingException{

    public DowngradeException() {
    }

    public DowngradeException(String message) {
        super(message);
    }

    public DowngradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DowngradeException(Throwable cause) {
        super(cause);
    }

    public DowngradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
