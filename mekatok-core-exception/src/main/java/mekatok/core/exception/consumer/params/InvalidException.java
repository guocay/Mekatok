package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 无效的用户输入
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0402", message = "invalid user input")
public class InvalidException extends ParamsException{

    public InvalidException() {
    }

    public InvalidException(String message) {
        super(message);
    }

    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidException(Throwable cause) {
        super(cause);
    }

    public InvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
