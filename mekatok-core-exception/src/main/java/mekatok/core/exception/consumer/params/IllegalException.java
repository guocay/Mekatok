package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户输入内容非法
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0430", message = "User input is illegal")
public class IllegalException extends ParamsException{

    public IllegalException() {
    }

    public IllegalException(String message) {
        super(message);
    }

    public IllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalException(Throwable cause) {
        super(cause);
    }

    public IllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
