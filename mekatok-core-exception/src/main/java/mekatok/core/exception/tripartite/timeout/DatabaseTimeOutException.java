package mekatok.core.exception.tripartite.timeout;

import mekatok.core.exception.ExceptionMark;

/**
 * 数据库服务超时
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0250", message = "database service timed out")
public class DatabaseTimeOutException extends TimeOutException{

    public DatabaseTimeOutException() {
    }

    public DatabaseTimeOutException(String message) {
        super(message);
    }

    public DatabaseTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseTimeOutException(Throwable cause) {
        super(cause);
    }

    public DatabaseTimeOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
