package icu.guokai.mekatok.framework.core.mistake;

import java.lang.annotation.*;

/**
 * 用于定义 平台内 错误的 编码.
 * @author GuoKai
 * @date 2021/8/5
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MistakeCode {

    /**
     * 错误编码
     * 约定格式 "M + 模块名 + 0000"
     * @return 错误编码
     */
    String value();

}
