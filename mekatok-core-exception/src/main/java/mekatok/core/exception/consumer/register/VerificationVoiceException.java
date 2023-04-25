package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 语音验证码校验失败
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0133", message = "Voice verification code verification failed")
public class VerificationVoiceException extends VerificationCodeException {

    public VerificationVoiceException() {
    }

    public VerificationVoiceException(String message) {
        super(message);
    }

    public VerificationVoiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationVoiceException(Throwable cause) {
        super(cause);
    }

    public VerificationVoiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
