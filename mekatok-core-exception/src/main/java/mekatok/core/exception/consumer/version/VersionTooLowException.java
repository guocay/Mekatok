package mekatok.core.exception.consumer.version;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户请求API版本过低
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0803", message = "User request API version is too low")
public class VersionTooLowException extends VersionException{

    public VersionTooLowException() {
    }

    public VersionTooLowException(String message) {
        super(message);
    }

    public VersionTooLowException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionTooLowException(Throwable cause) {
        super(cause);
    }

    public VersionTooLowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
