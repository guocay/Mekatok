package com.github.guokaia.mekatok.microservice;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Objects;

/**
 * 这个类是为了处理在 @FeignClient 接口中不能使用 @RequestMapping 注解.<br/>
 * PS: 不能用的原因是 RequestMappingHandlerMapping 中 只要是@RequestMapping注解的类都会被添加到映射中.<br/>
 * 所以,这里要重写下里面的 isHandler(), 过滤掉包括 @FeignClient注解的类.
 * @author GuoKai
 * @date 2022/2/3
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
public class OpenFeignMappingAutoConfiguration implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new FeignFilterRequestMappingHandlerMapping();
    }

    private class FeignFilterRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && (Objects.isNull(AnnotationUtils.findAnnotation(beanType, FeignClient.class)));
        }
    }
}
