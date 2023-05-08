package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 系统容灾功能触发
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0200", message = "The system disaster recovery function is triggered")
public class HedgingException extends ProviderException{

    public HedgingException() {
    }

    public HedgingException(String message) {
        super(message);
    }

    public HedgingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HedgingException(Throwable cause) {
        super(cause);
    }

    public HedgingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
