package mekatok.core.exception.consumer.authority;

import mekatok.core.exception.ExceptionMark;

/**
 * 授权已过期
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0311", message = "Authorization has expired")
public class AuthorityExpiredException extends RejectPrivacyException{

    public AuthorityExpiredException() {
    }

    public AuthorityExpiredException(String message) {
        super(message);
    }

    public AuthorityExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorityExpiredException(Throwable cause) {
        super(cause);
    }

    public AuthorityExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
