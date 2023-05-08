package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 服务已欠费
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0330", message = "Service is in arrears")
public class ArrearsException extends AuthorityException{

    public ArrearsException() {
    }

    public ArrearsException(String message) {
        super(message);
    }

    public ArrearsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrearsException(Throwable cause) {
        super(cause);
    }

    public ArrearsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
