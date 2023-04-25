package mekatok.core.exception;

import mekatok.core.component.exception.PlatformException;

/**
 * 断言异常
 * @author aCay
 * @since 2022/8/10
 */
@ExceptionMark(code = "D0001", message = AssertionException.EXCEPTION_MESSAGE)
public class AssertionException extends PlatformException {

    public static final String EXCEPTION_MESSAGE = "Assertion error";

    public AssertionException() {
        this(EXCEPTION_MESSAGE);
    }

    public AssertionException(String message) {
        super(message);
    }

    public AssertionException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionException(Throwable cause) {
        super(cause);
    }

    public AssertionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
