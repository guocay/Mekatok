package mekatok.core.exception.consumer.register;

import mekatok.core.exception.ExceptionMark;

/**
 * 地址校验异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0152", message = "Address verification exception")
public class MainInfoAddressException extends MainInfoException{

    public MainInfoAddressException() {
    }

    public MainInfoAddressException(String message) {
        super(message);
    }

    public MainInfoAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public MainInfoAddressException(Throwable cause) {
        super(cause);
    }

    public MainInfoAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
