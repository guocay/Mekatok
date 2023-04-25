package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 消息投递出错
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0121", message = "message delivery error")
public class MessageDeliveryException extends MessageServiceException{

    public MessageDeliveryException() {
    }

    public MessageDeliveryException(String message) {
        super(message);
    }

    public MessageDeliveryException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageDeliveryException(Throwable cause) {
        super(cause);
    }

    public MessageDeliveryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
