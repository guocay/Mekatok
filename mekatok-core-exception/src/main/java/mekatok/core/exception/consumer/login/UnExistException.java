package mekatok.core.exception.consumer.login;

import mekatok.core.exception.ExceptionMark;

/**
 * 账号不存在
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0201", message = "Account does not exist")
public class UnExistException extends LoginException{

    public UnExistException() {
    }

    public UnExistException(String message) {
        super(message);
    }

    public UnExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnExistException(Throwable cause) {
        super(cause);
    }

    public UnExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
