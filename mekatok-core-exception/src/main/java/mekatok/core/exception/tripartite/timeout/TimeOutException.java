package mekatok.core.exception.tripartite.timeout;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.tripartite.TripartiteException;

/**
 * 第三方系统执行超时
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0200", message = "Third-party system execution timed out")
public class TimeOutException extends TripartiteException {

    public TimeOutException() {
    }

    public TimeOutException(String message) {
        super(message);
    }

    public TimeOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeOutException(Throwable cause) {
        super(cause);
    }

    public TimeOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
