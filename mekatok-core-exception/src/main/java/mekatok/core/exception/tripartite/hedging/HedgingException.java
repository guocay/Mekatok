package mekatok.core.exception.tripartite.hedging;

import mekatok.core.exception.ExceptionMark;
import mekatok.core.exception.tripartite.TripartiteException;

/**
 * 第三方容灾策略被触发
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0400", message = "A third-party disaster recovery strategy is triggered")
public class HedgingException extends TripartiteException {

    public HedgingException() {
    }

    public HedgingException(String message) {
        super(message);
    }

    public HedgingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HedgingException(Throwable cause) {
        super(cause);
    }

    public HedgingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
