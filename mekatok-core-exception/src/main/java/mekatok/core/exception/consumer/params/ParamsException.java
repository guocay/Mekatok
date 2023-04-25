package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 账户请求参数错误
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0400", message = "Account request parameter error")
public class ParamsException extends ConsumerException {

    public ParamsException() {
    }

    public ParamsException(String message) {
        super(message);
    }

    public ParamsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamsException(Throwable cause) {
        super(cause);
    }

    public ParamsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
