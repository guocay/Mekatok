package mekatok.core.exception.tripartite.database;

import mekatok.core.exception.ExceptionMark;

/**
 * 数据库表列不存在
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0312", message = "database table row does not exist")
public class RowNotExistException extends DatabaseException{

    public RowNotExistException() {
    }

    public RowNotExistException(String message) {
        super(message);
    }

    public RowNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RowNotExistException(Throwable cause) {
        super(cause);
    }

    public RowNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
