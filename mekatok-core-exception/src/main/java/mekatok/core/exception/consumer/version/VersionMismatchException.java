package mekatok.core.exception.consumer.version;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户请求API版本不匹配
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0801", message = "User request API version mismatch")
public class VersionMismatchException extends VersionException{

    public VersionMismatchException() {
    }

    public VersionMismatchException(String message) {
        super(message);
    }

    public VersionMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionMismatchException(Throwable cause) {
        super(cause);
    }

    public VersionMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
