package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 包含恶意跳转链接
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0401", message = "Contains malicious jump links")
public class LinkException extends ParamsException {

    public LinkException() {
    }

    public LinkException(String message) {
        super(message);
    }

    public LinkException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkException(Throwable cause) {
        super(cause);
    }

    public LinkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
