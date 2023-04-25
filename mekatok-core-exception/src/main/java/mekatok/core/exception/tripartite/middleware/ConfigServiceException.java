package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 配置 服务异常
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0140", message = "Config service exception")
public class ConfigServiceException extends MiddlewareException{

    public ConfigServiceException() {
    }

    public ConfigServiceException(String message) {
        super(message);
    }

    public ConfigServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigServiceException(Throwable cause) {
        super(cause);
    }

    public ConfigServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
