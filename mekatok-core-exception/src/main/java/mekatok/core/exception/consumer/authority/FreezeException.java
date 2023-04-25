package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 账户权限被冻结
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0322", message = "Account authority is frozen")
public class FreezeException extends InterceptException{

    public FreezeException() {
    }

    public FreezeException(String message) {
        super(message);
    }

    public FreezeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FreezeException(Throwable cause) {
        super(cause);
    }

    public FreezeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
