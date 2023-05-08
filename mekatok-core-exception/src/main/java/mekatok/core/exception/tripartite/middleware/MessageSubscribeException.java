package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 消息订阅出错
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0123", message = "message subscribe error")
public class MessageSubscribeException extends MessageServiceException{

    public MessageSubscribeException() {
    }

    public MessageSubscribeException(String message) {
        super(message);
    }

    public MessageSubscribeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageSubscribeException(Throwable cause) {
        super(cause);
    }

    public MessageSubscribeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
