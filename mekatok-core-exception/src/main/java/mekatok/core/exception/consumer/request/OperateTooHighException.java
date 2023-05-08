package mekatok.core.exception.consumer.request;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户操作超过限制
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0503",message = "User action exceeds limit")
public class OperateTooHighException extends RequestException{

    public OperateTooHighException() {
    }

    public OperateTooHighException(String message) {
        super(message);
    }

    public OperateTooHighException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperateTooHighException(Throwable cause) {
        super(cause);
    }

    public OperateTooHighException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
