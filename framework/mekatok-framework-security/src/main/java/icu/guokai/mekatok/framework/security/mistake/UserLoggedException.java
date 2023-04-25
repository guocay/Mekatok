package icu.guokai.mekatok.framework.security.mistake;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 用户已登录异常
 * @author GuoKai
 * @date 2021/8/18
 */
@MistakeCode("M-SECURITY-0003")
public class UserLoggedException extends MekatokException {

    private static final long serialVersionUID = 4568325956201154973L;

    public UserLoggedException() {
    }

    public UserLoggedException(String message) {
        super(message);
    }

    public UserLoggedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoggedException(Throwable cause) {
        super(cause);
    }

    public UserLoggedException(String template, Object... params) {
        super(template, params);
    }

    public UserLoggedException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public UserLoggedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
