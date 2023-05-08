package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 访问对象隐私设置被拒绝
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0310", message = "Access to Object Privacy Device Denied")
public class RejectPrivacyException extends AuthorityException{

    public RejectPrivacyException() {
    }

    public RejectPrivacyException(String message) {
        super(message);
    }

    public RejectPrivacyException(String message, Throwable cause) {
        super(message, cause);
    }

    public RejectPrivacyException(Throwable cause) {
        super(cause);
    }

    public RejectPrivacyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
