package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 系统资源异常
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0300", message = "System resource exception")
public class ResourceException extends ProviderException{

    public ResourceException() {
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }

    public ResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
