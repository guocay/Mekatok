package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户名校验失败
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0110", message = "Username verification failed")
public class UsernameException extends RegisterException{

    public UsernameException() {
    }

    public UsernameException(String message) {
        super(message);
    }

    public UsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameException(Throwable cause) {
        super(cause);
    }

    public UsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
