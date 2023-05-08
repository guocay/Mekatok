package mekatok.core.exception.tripartite.database;

import mekatok.core.exception.ExceptionMark;

/**
 * 数据库表不存在
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0311", message = "database table does not exist")
public class TableNotExistException extends DatabaseException{

    public TableNotExistException() {
    }

    public TableNotExistException(String message) {
        super(message);
    }

    public TableNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableNotExistException(Throwable cause) {
        super(cause);
    }

    public TableNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
