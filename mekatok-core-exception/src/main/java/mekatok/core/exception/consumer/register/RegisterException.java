package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 用户注册错误
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0100", message = "User registration error")
public class RegisterException extends ConsumerException {

    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterException(Throwable cause) {
        super(cause);
    }

    public RegisterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
