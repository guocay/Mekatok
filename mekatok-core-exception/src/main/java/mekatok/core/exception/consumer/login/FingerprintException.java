package mekatok.core.exception.consumer.login;

import mekatok.core.exception.ExceptionMark;

/**
 * 账户指纹校验失败
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0221", message = "Account fingerprint verification failed")
public class FingerprintException extends IdentityException{

    public FingerprintException() {
    }

    public FingerprintException(String message) {
        super(message);
    }

    public FingerprintException(String message, Throwable cause) {
        super(message, cause);
    }

    public FingerprintException(Throwable cause) {
        super(cause);
    }

    public FingerprintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
