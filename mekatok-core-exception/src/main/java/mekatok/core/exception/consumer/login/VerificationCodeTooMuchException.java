package mekatok.core.exception.consumer.login;

import mekatok.core.exception.ExceptionMark;

/**
 * 账号验证码输入次数过多
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0241", message = "Account verification code entered too many times")
public class VerificationCodeTooMuchException extends VerificationCodeException{

    public VerificationCodeTooMuchException() {
    }

    public VerificationCodeTooMuchException(String message) {
        super(message);
    }

    public VerificationCodeTooMuchException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationCodeTooMuchException(Throwable cause) {
        super(cause);
    }

    public VerificationCodeTooMuchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
