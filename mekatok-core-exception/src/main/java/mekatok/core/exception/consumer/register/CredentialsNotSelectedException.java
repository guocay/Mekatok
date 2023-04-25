package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户证件未选择
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0141", message = "User ID not selected")
public class CredentialsNotSelectedException extends CredentialsException{

    public CredentialsNotSelectedException() {
    }

    public CredentialsNotSelectedException(String message) {
        super(message);
    }

    public CredentialsNotSelectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CredentialsNotSelectedException(Throwable cause) {
        super(cause);
    }

    public CredentialsNotSelectedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
