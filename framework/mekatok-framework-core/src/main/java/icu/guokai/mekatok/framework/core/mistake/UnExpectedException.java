package icu.guokai.mekatok.framework.core.mistake;

/**
 * 其他不在预期内的异常
 * @author GuoKai
 * @date 2021/8/18
 */
@MistakeCode("M-CORE-9999")
public class UnExpectedException extends Throwable{

    public UnExpectedException() {
        this("Errors that are not within business expectations.");
    }

    public UnExpectedException(String message) {
        super(message);
    }

    public UnExpectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnExpectedException(Throwable cause) {
        super(cause);
    }

    public UnExpectedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
