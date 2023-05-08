package mekatok.core.exception.consumer;

import mekatok.core.component.exception.PlatformException;
import mekatok.core.exception.ExceptionMark;

/**
 * 消费者 主异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0001", message = "consumer error")
public class ConsumerException extends PlatformException {

    public ConsumerException() {
    }

    public ConsumerException(String message) {
        super(message);
    }

    public ConsumerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsumerException(Throwable cause) {
        super(cause);
    }

    public ConsumerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
