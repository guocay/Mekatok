package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户证件异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0140", message = "User ID is abnormal")
public class CredentialsException extends RegisterException{

    public CredentialsException() {
    }

    public CredentialsException(String message) {
        super(message);
    }

    public CredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CredentialsException(Throwable cause) {
        super(cause);
    }

    public CredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
