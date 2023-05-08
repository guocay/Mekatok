package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 消息消费出错
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0122", message = "message consume error")
public class MessageConsumeException extends MessageServiceException{

    public MessageConsumeException() {
    }

    public MessageConsumeException(String message) {
        super(message);
    }

    public MessageConsumeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageConsumeException(Throwable cause) {
        super(cause);
    }

    public MessageConsumeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
