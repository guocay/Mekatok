package mekatok.core.exception.tripartite.middleware;

import mekatok.core.exception.ExceptionMark;

/**
 * CDN 服务出错
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0152", message = "CDN service error")
public class CdnException extends NetworkServiceException{

    public CdnException() {
    }

    public CdnException(String message) {
        super(message);
    }

    public CdnException(String message, Throwable cause) {
        super(message, cause);
    }

    public CdnException(Throwable cause) {
        super(cause);
    }

    public CdnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
