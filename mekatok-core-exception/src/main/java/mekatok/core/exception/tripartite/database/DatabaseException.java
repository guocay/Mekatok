package mekatok.core.exception.tripartite.database;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.tripartite.TripartiteException;

/**
 * 数据库服务出错
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0300", message = "database service error")
public class DatabaseException extends TripartiteException {

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
