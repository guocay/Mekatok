package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * RPC 服务未找到
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0111", message = "RPC service not found")
public class RpcServiceNotFoundException extends RpcServiceException{

    public RpcServiceNotFoundException() {
    }

    public RpcServiceNotFoundException(String message) {
        super(message);
    }

    public RpcServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcServiceNotFoundException(Throwable cause) {
        super(cause);
    }

    public RpcServiceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
