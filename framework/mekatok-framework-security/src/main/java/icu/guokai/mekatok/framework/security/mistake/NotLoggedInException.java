package icu.guokai.mekatok.framework.security.mistake;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 用户未登录
 * @author GuoKai
 * @date 2021/8/16
 */
@MistakeCode("M-SECURITY-0002")
public class NotLoggedInException extends MekatokException {

    private static final long serialVersionUID = 2969910467012137070L;

    public NotLoggedInException() {
    }

    public NotLoggedInException(String message) {
        super(message);
    }

    public NotLoggedInException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLoggedInException(Throwable cause) {
        super(cause);
    }

    public NotLoggedInException(String template, Object... params) {
        super(template, params);
    }

    public NotLoggedInException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public NotLoggedInException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
