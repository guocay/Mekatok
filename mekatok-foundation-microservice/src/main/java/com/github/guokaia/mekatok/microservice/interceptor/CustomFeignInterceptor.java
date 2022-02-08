package com.github.guokaia.mekatok.microservice.interceptor;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.webmvc.whoami.MyselfHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

/**
 * 自定义的feign拦截器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/3
 */
@Component
@ConditionalOnClass(MyselfHolder.class)
public class CustomFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(Global.AUTHENTICATION_MARK, MyselfHolder.get());
    }
}
