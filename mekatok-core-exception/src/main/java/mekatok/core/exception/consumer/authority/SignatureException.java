package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 消费者签名异常
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0340", message = "Consumer signature error")
public class SignatureException extends AuthorityException{

    public SignatureException() {
    }

    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignatureException(Throwable cause) {
        super(cause);
    }

    public SignatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
