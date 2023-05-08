package mekatok.core.exception.consumer.login;

import mekatok.core.exception.ExceptionMark;

/**
 * 账户验证码错误
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0240", message = "Account verification code error")
public class VerificationCodeException extends LoginException{

    public VerificationCodeException() {
    }

    public VerificationCodeException(String message) {
        super(message);
    }

    public VerificationCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationCodeException(Throwable cause) {
        super(cause);
    }

    public VerificationCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
