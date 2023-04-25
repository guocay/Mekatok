package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 系统资源访问异常
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0320", message = "System resource access exception")
public class ResourceAccessException extends ResourceException {

    public ResourceAccessException() {
    }

    public ResourceAccessException(String message) {
        super(message);
    }

    public ResourceAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
