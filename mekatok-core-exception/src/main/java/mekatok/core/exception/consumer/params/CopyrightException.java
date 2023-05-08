package mekatok.core.exception.consumer.params;

import mekatok.core.exception.ExceptionMark;

/**
 * 文件侵犯版权
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0433", message = "File infringes copyright")
public class CopyrightException extends IllegalException{

    public CopyrightException() {
    }

    public CopyrightException(String message) {
        super(message);
    }

    public CopyrightException(String message, Throwable cause) {
        super(message, cause);
    }

    public CopyrightException(Throwable cause) {
        super(cause);
    }

    public CopyrightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
