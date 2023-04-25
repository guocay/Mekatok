package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * RPC 服务接口不存在
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0113", message = "RPC service interface does not exist")
public class RpcServiceNotPortException extends RpcServiceException{

    public RpcServiceNotPortException() {
    }

    public RpcServiceNotPortException(String message) {
        super(message);
    }

    public RpcServiceNotPortException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcServiceNotPortException(Throwable cause) {
        super(cause);
    }

    public RpcServiceNotPortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
