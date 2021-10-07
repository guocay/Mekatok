package icu.guokai.mekatok.framework.plugin.mistake;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 服务器不被信任异常
 * @author GuoKai
 * @date 2021/8/17
 */
@MistakeCode("M-PLUGIN-0002")
public class ServerDistrustException extends MekatokException {

    private static final long serialVersionUID = -4265485484981988755L;

    public ServerDistrustException() {
    }

    public ServerDistrustException(String message) {
        super(message);
    }

    public ServerDistrustException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerDistrustException(Throwable cause) {
        super(cause);
    }

    public ServerDistrustException(String template, Object... params) {
        super(template, params);
    }

    public ServerDistrustException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public ServerDistrustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
