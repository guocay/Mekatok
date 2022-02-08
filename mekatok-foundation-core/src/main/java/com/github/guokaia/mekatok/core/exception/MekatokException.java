package com.github.guokaia.mekatok.core.exception;

/**
 * 平台自定义异常类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/26
 */
@ExceptionDefinition(code = "M-CORE-0001", message = "Mekatok平台异常")
public class MekatokException extends RuntimeException {

    public MekatokException() {
    }

    public MekatokException(String message) {
        super(message);
    }

    public MekatokException(String message, Throwable cause) {
        super(message, cause);
    }

    public MekatokException(Throwable cause) {
        super(cause);
    }

    public MekatokException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
