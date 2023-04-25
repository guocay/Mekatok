package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 无权限访问 API
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0312", message = "No access to API")
public class ApiUnauthorizedException extends RejectPrivacyException{

    public ApiUnauthorizedException() {
    }

    public ApiUnauthorizedException(String message) {
        super(message);
    }

    public ApiUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiUnauthorizedException(Throwable cause) {
        super(cause);
    }

    public ApiUnauthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
