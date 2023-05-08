package mekatok.core.exception.consumer.request;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 用户请求服务错误
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0500", message = "User request service error")
public class RequestException extends ConsumerException {

    public RequestException() {
    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
