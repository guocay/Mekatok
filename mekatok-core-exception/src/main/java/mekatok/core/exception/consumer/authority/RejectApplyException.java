package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 权限申请被拒绝
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0303", message = "Permission request denied")
public class RejectApplyException extends AuthorityException{

    public RejectApplyException() {
    }

    public RejectApplyException(String message) {
        super(message);
    }

    public RejectApplyException(String message, Throwable cause) {
        super(message, cause);
    }

    public RejectApplyException(Throwable cause) {
        super(cause);
    }

    public RejectApplyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
