package mekatok.core.exception.provider;

import mekatok.core.component.exception.PlatformException;
import mekatok.core.exception.ExceptionMark;

/**
 * 服务端错误
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0001", message = "server error")
public class ProviderException extends PlatformException {

    public ProviderException() {
    }

    public ProviderException(String message) {
        super(message);
    }

    public ProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProviderException(Throwable cause) {
        super(cause);
    }

    public ProviderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
