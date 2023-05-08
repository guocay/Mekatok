package mekatok.core.exception.tripartite.database;

import mekatok.core.exception.ExceptionMark;

/**
 * 多表关联中存在多个相同名称的列
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0321", message = "Multiple columns with the same name exist in a multi-table association")
public class SameRowException extends DatabaseException{

    public SameRowException() {
    }

    public SameRowException(String message) {
        super(message);
    }

    public SameRowException(String message, Throwable cause) {
        super(message, cause);
    }

    public SameRowException(Throwable cause) {
        super(cause);
    }

    public SameRowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
