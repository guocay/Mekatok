package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 请求批量操作的个数允许范围
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0426", message = "The allowable range of the number of requested batch operations")
public class BatchException extends ScopeException{

    public BatchException() {
    }

    public BatchException(String message) {
        super(message);
    }

    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatchException(Throwable cause) {
        super(cause);
    }

    public BatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
