package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 消费者 访问权限异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0300", message = "Access permission error")
public class AuthorityException extends ConsumerException {

    public AuthorityException() {
    }

    public AuthorityException(String message) {
        super(message);
    }

    public AuthorityException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorityException(Throwable cause) {
        super(cause);
    }

    public AuthorityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
