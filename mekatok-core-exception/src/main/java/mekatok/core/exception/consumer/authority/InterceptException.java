package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户访问被拦截
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0320", message = "Consumer access is blocked")
public class InterceptException extends AuthorityException{

    public InterceptException() {
    }

    public InterceptException(String message) {
        super(message);
    }

    public InterceptException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterceptException(Throwable cause) {
        super(cause);
    }

    public InterceptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
