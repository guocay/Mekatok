package icu.guokai.mekatok.framework.core.asserts.exception;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 断言失败
 * @author GuoKai
 * @date 2021/10/6
 */
@MistakeCode("M-ASSERT-0000")
public class AssertionsException extends MekatokException {

    private static final long serialVersionUID = -2287587319081094425L;

    public AssertionsException() {
    }

    public AssertionsException(String message) {
        super(message);
    }

    public AssertionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsException(Throwable cause) {
        super(cause);
    }

    public AssertionsException(String template, Object... params) {
        super(template, params);
    }

    public AssertionsException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public AssertionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
