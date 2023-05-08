package mekatok.core.exception.consumer.resource;

import mekatok.core.exception.ExceptionMark;

/**
 * 用户OOS空间不足
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0601", message = "User OOS space is insufficient")
public class SpaceInsufficientException extends ResourceException {

    public SpaceInsufficientException() {
    }

    public SpaceInsufficientException(String message) {
        super(message);
    }

    public SpaceInsufficientException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpaceInsufficientException(Throwable cause) {
        super(cause);
    }

    public SpaceInsufficientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
