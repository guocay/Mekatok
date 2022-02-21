package com.github.guokaia.mekatok.microservice.interceptor;

import cn.hutool.core.lang.UUID;
import com.github.guokaia.mekatok.webmvc.whoami.MyselfHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import static com.github.guokaia.mekatok.common.Global.AUTHENTICATION_MARK;
import static com.github.guokaia.mekatok.common.Global.IDEMPOTENT_GUARANTEE;

/**
 * 自定义的feign拦截器
 * @author GuoKai
 * @date 2022/2/3
 */
@Component
@ConditionalOnClass(MyselfHolder.class)
public class CustomFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(AUTHENTICATION_MARK, MyselfHolder.get());
        template.header(IDEMPOTENT_GUARANTEE, UUID.randomUUID().toString());
    }
}
