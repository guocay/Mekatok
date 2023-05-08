package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 消费者RSA签名异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0341", message = "Consumer signature error")
public class SignatureRsaException extends SignatureException{

    public SignatureRsaException() {
    }

    public SignatureRsaException(String message) {
        super(message);
    }

    public SignatureRsaException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignatureRsaException(Throwable cause) {
        super(cause);
    }

    public SignatureRsaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
