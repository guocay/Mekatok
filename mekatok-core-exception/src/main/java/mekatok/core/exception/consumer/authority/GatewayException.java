package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 网关访问受限
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0324", message = "Gateway access is restricted")
public class GatewayException extends InterceptException{
    public GatewayException() {
    }

    public GatewayException(String message) {
        super(message);
    }

    public GatewayException(String message, Throwable cause) {
        super(message, cause);
    }

    public GatewayException(Throwable cause) {
        super(cause);
    }

    public GatewayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
