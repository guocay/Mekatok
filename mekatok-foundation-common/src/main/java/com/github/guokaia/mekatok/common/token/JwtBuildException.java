package com.github.guokaia.mekatok.common.token;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/3
 */
@ExceptionDefinition(code = "M_COMMON_002", message = "JWT内置对象构建异常")
public class JwtBuildException extends MekatokException {
    public JwtBuildException() {
        super();
    }

    public JwtBuildException(String message) {
        super(message);
    }

    public JwtBuildException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtBuildException(Throwable cause) {
        super(cause);
    }

    public JwtBuildException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
