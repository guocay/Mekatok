package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * VPN 服务出错
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0151", message = "VPN service error")
public class VpnException extends NetworkServiceException{

    public VpnException() {
    }

    public VpnException(String message) {
        super(message);
    }

    public VpnException(String message, Throwable cause) {
        super(message, cause);
    }

    public VpnException(Throwable cause) {
        super(cause);
    }

    public VpnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
