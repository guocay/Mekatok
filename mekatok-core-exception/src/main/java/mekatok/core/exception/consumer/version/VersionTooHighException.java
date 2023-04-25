package mekatok.core.exception.consumer.version;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户请求API版本过高
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0802", message = "User request API version is too high")
public class VersionTooHighException extends VersionException{

    public VersionTooHighException() {
    }

    public VersionTooHighException(String message) {
        super(message);
    }

    public VersionTooHighException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionTooHighException(Throwable cause) {
        super(cause);
    }

    public VersionTooHighException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
