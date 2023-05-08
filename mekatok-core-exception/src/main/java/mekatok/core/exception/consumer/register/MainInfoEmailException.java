package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 邮箱校验异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0153", message = "Email verification exception")
public class MainInfoEmailException extends MainInfoException{

    public MainInfoEmailException() {
    }

    public MainInfoEmailException(String message) {
        super(message);
    }

    public MainInfoEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public MainInfoEmailException(Throwable cause) {
        super(cause);
    }

    public MainInfoEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
