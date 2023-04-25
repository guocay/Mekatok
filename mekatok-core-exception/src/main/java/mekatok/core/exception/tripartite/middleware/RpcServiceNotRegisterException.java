package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * RPC 服务未注册
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0112", message = "RPC service not register")
public class RpcServiceNotRegisterException extends RpcServiceException{

    public RpcServiceNotRegisterException() {
    }

    public RpcServiceNotRegisterException(String message) {
        super(message);
    }

    public RpcServiceNotRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcServiceNotRegisterException(Throwable cause) {
        super(cause);
    }

    public RpcServiceNotRegisterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
