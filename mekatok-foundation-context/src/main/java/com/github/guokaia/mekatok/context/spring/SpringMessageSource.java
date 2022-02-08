package com.github.guokaia.mekatok.context.spring;

import com.github.guokaia.mekatok.common.Global;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 自定义消息服务
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/26
 */
public class SpringMessageSource extends ResourceBundleMessageSource implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        setDefaultEncoding(Global.DEFAULT_CHARSET_NAME);
        setBasename(Global.SPRING_MESSAGE_BASE_NAME);
        setUseCodeAsDefaultMessage(true);
    }
}
