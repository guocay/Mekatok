package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 地域黑名单
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0325", message = "Regional blacklist")
public class RegionalException extends InterceptException{

    public RegionalException() {
    }

    public RegionalException(String message) {
        super(message);
    }

    public RegionalException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegionalException(Throwable cause) {
        super(cause);
    }

    public RegionalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
