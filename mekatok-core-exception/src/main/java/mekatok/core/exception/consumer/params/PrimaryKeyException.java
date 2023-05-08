package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 主键字段不得为空
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0411", message = "Primary key field must not be empty")
public class PrimaryKeyException extends RequiredException{

    public PrimaryKeyException() {
    }

    public PrimaryKeyException(String message) {
        super(message);
    }

    public PrimaryKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrimaryKeyException(Throwable cause) {
        super(cause);
    }

    public PrimaryKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
