package icu.guokai.mekatok.framework.core.liteflow;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;

/**
 * 用于定义 LiteFlow 流程中的异常
 * @author GuoKai
 * @date 2021/10/30
 */
@MistakeCode("M-LITEFLOW-0000")
public class LiteFlowException extends MekatokException {

    private static final long serialVersionUID = 2039879143966195794L;

    public LiteFlowException() {
    }

    public LiteFlowException(String message) {
        super(message);
    }

    public LiteFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public LiteFlowException(Throwable cause) {
        super(cause);
    }

    public LiteFlowException(String template, Object... params) {
        super(template, params);
    }

    public LiteFlowException(Throwable cause, String template, Object... params) {
        super(cause, template, params);
    }

    public LiteFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
