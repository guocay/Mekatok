package mekatok.core.exception.tripartite.timeout;

import mekatok.core.exception.ExceptionMark;

/**
 * RPC执行超时
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0210", message = "RPC execution timed out")
public class RpcTimeOutException extends TimeOutException{

    public RpcTimeOutException() {
    }

    public RpcTimeOutException(String message) {
        super(message);
    }

    public RpcTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcTimeOutException(Throwable cause) {
        super(cause);
    }

    public RpcTimeOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
