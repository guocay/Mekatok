package mekatok.core.exception.consumer.login;

import mekatok.core.exception.ExceptionMark;

/**
 * 账号未获得第三方授权
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0223", message = "The account is not authorized by a third party")
public class AuthorizeException extends IdentityException{

    public AuthorizeException() {
    }

    public AuthorizeException(String message) {
        super(message);
    }

    public AuthorizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizeException(Throwable cause) {
        super(cause);
    }

    public AuthorizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
