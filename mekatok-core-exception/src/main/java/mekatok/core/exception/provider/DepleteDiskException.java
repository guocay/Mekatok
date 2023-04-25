package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 磁盘资源消耗殆尽
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0311", message = "Disk resources exhausted")
public class DepleteDiskException extends DepleteException{

    public DepleteDiskException() {
    }

    public DepleteDiskException(String message) {
        super(message);
    }

    public DepleteDiskException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepleteDiskException(Throwable cause) {
        super(cause);
    }

    public DepleteDiskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
