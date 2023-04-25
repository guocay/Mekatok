package mekatok.core.exception.consumer.request;

import mekatok.core.exception.ExceptionMark;

/**
 * 请求并发超出限制
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0502", message = "Request Concurrency Exceeded Limit")
public class ConcurrencyTooHighException extends RequestException{

    public ConcurrencyTooHighException() {
    }

    public ConcurrencyTooHighException(String message) {
        super(message);
    }

    public ConcurrencyTooHighException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcurrencyTooHighException(Throwable cause) {
        super(cause);
    }

    public ConcurrencyTooHighException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
