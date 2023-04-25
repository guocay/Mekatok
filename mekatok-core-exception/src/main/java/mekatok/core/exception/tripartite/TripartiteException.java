package mekatok.core.exception.tripartite;

import mekatok.core.component.exception.PlatformException;
import mekatok.core.exception.ExceptionMark;

/**
 * 第三方错误
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0001", message = "third party error")
public class TripartiteException extends PlatformException {

    public TripartiteException() {
    }

    public TripartiteException(String message) {
        super(message);
    }

    public TripartiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripartiteException(Throwable cause) {
        super(cause);
    }

    public TripartiteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
