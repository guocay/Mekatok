package mekatok.core.exception.consumer.version;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 用户版本错误
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0800", message = "wrong user version")
public class VersionException extends ConsumerException {

    public VersionException() {
    }

    public VersionException(String message) {
        super(message);
    }

    public VersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionException(Throwable cause) {
        super(cause);
    }

    public VersionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
