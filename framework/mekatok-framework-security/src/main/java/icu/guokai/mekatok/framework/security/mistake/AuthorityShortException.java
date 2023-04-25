package icu.guokai.mekatok.framework.security.mistake;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 用户权限不足
 * @author GuoKai
 * @date 2021/8/16
 */
@MistakeCode("M-SECURITY-0000")
public class AuthorityShortException extends MekatokException {

    private static final long serialVersionUID = 7864002784052334895L;

    public AuthorityShortException() {
    }

    public AuthorityShortException(String message) {
        super(message);
    }

    public AuthorityShortException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorityShortException(Throwable cause) {
        super(cause);
    }

    public AuthorityShortException(String template, Object... params) {
        super(template, params);
    }

    public AuthorityShortException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public AuthorityShortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
