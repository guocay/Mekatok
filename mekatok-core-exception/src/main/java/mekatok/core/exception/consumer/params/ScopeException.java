package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 请求参数超过了允许的范围
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0420", message = "The request parameter exceeds the allowed range")
public class ScopeException extends ParamsException{

    public ScopeException() {
    }

    public ScopeException(String message) {
        super(message);
    }

    public ScopeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScopeException(Throwable cause) {
        super(cause);
    }

    public ScopeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
