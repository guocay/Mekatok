package mekatok.core.exception.consumer.device;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 消费者设备错误
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A1000", message = "Consumer Device Error")
public class DeviceException extends ConsumerException {

    public DeviceException() {
    }

    public DeviceException(String message) {
        super(message);
    }

    public DeviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceException(Throwable cause) {
        super(cause);
    }

    public DeviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
