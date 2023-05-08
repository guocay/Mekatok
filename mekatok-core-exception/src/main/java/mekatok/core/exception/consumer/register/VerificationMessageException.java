package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 短信验证码校验失败
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0131", message = "SMS verification code verification failed")
public class VerificationMessageException extends VerificationCodeException {

    public VerificationMessageException() {
    }

    public VerificationMessageException(String message) {
        super(message);
    }

    public VerificationMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationMessageException(Throwable cause) {
        super(cause);
    }

    public VerificationMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
