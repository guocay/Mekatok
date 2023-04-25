package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 储存容量已满
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0133", message = "storage capacity is full")
public class CapacityFullException extends CacheServiceException{

    public CapacityFullException() {
    }

    public CapacityFullException(String message) {
        super(message);
    }

    public CapacityFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public CapacityFullException(Throwable cause) {
        super(cause);
    }

    public CapacityFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
