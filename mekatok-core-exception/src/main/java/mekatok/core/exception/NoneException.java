package mekatok.core.exception;

import mekatok.core.component.exception.PlatformException;

/**
 * 平台内无异常的异常表示
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "0000", message = "everything is ok")
public class NoneException extends PlatformException {

    /**
     * 静态实例
     */
    public static final NoneException INSTANCE = new NoneException();

}
