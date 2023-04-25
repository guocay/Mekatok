package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 系统资源消耗殆尽
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0310", message = "System resources are exhausted")
public class DepleteException extends ResourceException{

    public DepleteException() {
    }

    public DepleteException(String message) {
        super(message);
    }

    public DepleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepleteException(Throwable cause) {
        super(cause);
    }

    public DepleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
