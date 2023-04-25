package mekatok.core.component.exception;

/**
 * 平台异常信息 主类
 * @author aCay
 * @since 2022/8/8
 */
public abstract class PlatformException extends RuntimeException{

    public PlatformException() {
    }

    public PlatformException(String message) {
        super(message);
    }

    public PlatformException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatformException(Throwable cause) {
        super(cause);
    }

    public PlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
