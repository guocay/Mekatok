package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * RPC 服务异常
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0110", message = "RPC service exception")
public class RpcServiceException extends MiddlewareException{

    public RpcServiceException() {
    }

    public RpcServiceException(String message) {
        super(message);
    }

    public RpcServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcServiceException(Throwable cause) {
        super(cause);
    }

    public RpcServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
