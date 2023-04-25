package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * 消息分组未找到
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0124", message = "message group not found")
public class MessageGroupNotFoundException extends MessageServiceException{

    public MessageGroupNotFoundException() {
    }

    public MessageGroupNotFoundException(String message) {
        super(message);
    }

    public MessageGroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageGroupNotFoundException(Throwable cause) {
        super(cause);
    }

    public MessageGroupNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
