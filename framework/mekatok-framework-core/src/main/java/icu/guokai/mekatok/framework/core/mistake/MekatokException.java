package icu.guokai.mekatok.framework.core.mistake;

import icu.guokai.mekatok.framework.core.constant.Global;

/**
 * Mekatok平台 内置 顶级 错误
 * @author GuoKai
 * @date 2021/8/5
 */
@MistakeCode(Global.MISTAKE_CODE_DEFAULT)
public class MekatokException extends RuntimeException {

    public MekatokException() {}

    public MekatokException(String message) {
        super(message);
    }

    public MekatokException(String message, Throwable cause) {
        super(message, cause);
    }

    public MekatokException(Throwable cause) {
        super(cause);
    }

    public MekatokException(String template, Object... params){
        this(String.format(template, params));
    }

    public MekatokException(Throwable cause, String template, Object... params){
        this(String.format(template, params),cause);
    }

    public MekatokException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
