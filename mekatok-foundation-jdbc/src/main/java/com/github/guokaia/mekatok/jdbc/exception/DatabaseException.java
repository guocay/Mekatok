package com.github.guokaia.mekatok.jdbc.exception;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * @author GuoKai
 * @date 2022/2/6
 */
@ExceptionDefinition(code = "M-DATABSE-0001", message = "MyBatis 持久化异常")
public class DatabaseException extends MekatokException {
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
