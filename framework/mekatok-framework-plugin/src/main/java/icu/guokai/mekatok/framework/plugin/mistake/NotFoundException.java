package icu.guokai.mekatok.framework.plugin.mistake;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 请求路径不存在
 * @author GuoKai
 * @date 2021/8/16
 */
@MistakeCode("M-PLUGIN-0001")
public class NotFoundException extends MekatokException {

    private static final long serialVersionUID = -1433686526077922481L;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String template, Object... params) {
        super(template, params);
    }

    public NotFoundException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
