package com.github.guokaia.mekatok.core.exception;

import java.lang.annotation.*;

/**
 * 平台内用于定义 异常的编码
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/27
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionDefinition {

    /**
     * 错误编码<br/>
     * 约定格式 'M + 模块名 + 编码'<br/>
     * 例如: M_CORE_0001
     * @return 错误编码
     */
    String code();

    /**
     * 异常描述信息
     * @return [默认] 异常描述信息
     */
    String message();
}
