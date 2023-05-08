package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 线程池资源消耗殆尽
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0315", message = "Thread resources exhausted")
public class DepleteThreadException extends DepleteException{

    public DepleteThreadException() {
    }

    public DepleteThreadException(String message) {
        super(message);
    }

    public DepleteThreadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepleteThreadException(Throwable cause) {
        super(cause);
    }

    public DepleteThreadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
