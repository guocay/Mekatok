package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 护照校验异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0143", message = "Passport verification exception")
public class PassportException extends CredentialsException{
    public PassportException() {
    }

    public PassportException(String message) {
        super(message);
    }

    public PassportException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassportException(Throwable cause) {
        super(cause);
    }

    public PassportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
