package mekatok.core.exception.tripartite.database;

import mekatok.core.exception.ExceptionMark;

/**
 * 数据库死锁
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0331", message = "database deadlock")
public class DeadlockException extends DatabaseException{

    public DeadlockException() {
    }

    public DeadlockException(String message) {
        super(message);
    }

    public DeadlockException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeadlockException(Throwable cause) {
        super(cause);
    }

    public DeadlockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
