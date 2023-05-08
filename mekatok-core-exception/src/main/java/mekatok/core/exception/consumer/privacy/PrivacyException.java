package mekatok.core.exception.consumer.privacy;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.consumer.ConsumerException;

/**
 * 用户隐私未授权
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0900", message = "User Privacy Unauthorized")
public class PrivacyException extends ConsumerException {

    public PrivacyException() {
    }

    public PrivacyException(String message) {
        super(message);
    }

    public PrivacyException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrivacyException(Throwable cause) {
        super(cause);
    }

    public PrivacyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
