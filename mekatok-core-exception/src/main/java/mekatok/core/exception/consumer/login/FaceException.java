package mekatok.core.exception.consumer.login;

import mekatok.core.exception.ExceptionMark;

/**
 * 账户面容校验失败
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0222", message = "Account face verification failed")
public class FaceException extends IdentityException{

    public FaceException() {
    }

    public FaceException(String message) {
        super(message);
    }

    public FaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FaceException(Throwable cause) {
        super(cause);
    }

    public FaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
