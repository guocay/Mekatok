package mekatok.core.exception.consumer.request;

import mekatok.core.exception.ExceptionMark;

/**
 * 请求次数超过限制
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0501",message = "The number of requests exceeded the limit")
public class FrequencyTooHighException extends RequestException{

    public FrequencyTooHighException() {
    }

    public FrequencyTooHighException(String message) {
        super(message);
    }

    public FrequencyTooHighException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrequencyTooHighException(Throwable cause) {
        super(cause);
    }

    public FrequencyTooHighException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
