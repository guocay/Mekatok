package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * DOS 服务出错
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0153", message = "DOS service error")
public class DosException extends NetworkServiceException{

    public DosException() {
    }

    public DosException(String message) {
        super(message);
    }

    public DosException(String message, Throwable cause) {
        super(message, cause);
    }

    public DosException(Throwable cause) {
        super(cause);
    }

    public DosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
