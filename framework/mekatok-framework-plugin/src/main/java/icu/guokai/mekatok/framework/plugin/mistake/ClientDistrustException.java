package icu.guokai.mekatok.framework.plugin.mistake;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 客户端不被信任异常
 * @author GuoKai
 * @date 2021/8/17
 */
@MistakeCode("M-PLUGIN-0000")
public class ClientDistrustException extends MekatokException {

    private static final long serialVersionUID = 7914636508574495724L;

    public ClientDistrustException() {
    }

    public ClientDistrustException(String message) {
        super(message);
    }

    public ClientDistrustException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientDistrustException(Throwable cause) {
        super(cause);
    }

    public ClientDistrustException(String template, Object... params) {
        super(template, params);
    }

    public ClientDistrustException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public ClientDistrustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
