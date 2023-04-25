package icu.guokai.mekatok.framework.plugin.router;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import icu.guokai.mekatok.framework.core.event.EventCenter;
import icu.guokai.mekatok.framework.core.message.Message;
import icu.guokai.mekatok.framework.plugin.event.RouterCallAfter;
import icu.guokai.mekatok.framework.plugin.event.RouterCallBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * 使用拦截器的方式实现对Router的输入输出的事件发布
 * @author GuoKai
 * @date 2021/9/8
 */
@Configuration
@RestControllerAdvice
@SuppressWarnings("all")
public class RouterInterceptor implements HandlerInterceptor, WebMvcConfigurer, ResponseBodyAdvice<Object> {

    /**
     * 方法在请求处理之前被调用。
     * 该方法在 Interceptor 类中最先执行，用来进行一些前置初始化操作或是对当前请求做预处理，也可以进行一些判断来决定请求是否要继续进行下去。
     * 该方法的返回值是 Boolean 类型，
     * 当它返回 false 时，表示请求结束，后续的 Interceptor 和 Controller 都不会再执行；
     * 当它返回为 true 时会继续调用下一个 Interceptor 的 preHandle 方法，
     * 如果已经是最后一个 Interceptor 的时候就会调用当前请求的 Controller 方法。
     * @param request 请求对象
     * @param response 返回对象
     * @param handler 执行选择器
     * @return 是否通过
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        EventCenter.publish(new RouterCallBefore(request));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 将当前拦截类注册进 Spring
     * @param registry 注册管理对象
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType().isAssignableFrom(ResponseEntity.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof Message){
            // todo 如果返回的data字段是null,且tips里也没内容的时候,就在tips里设置提示语.
            var entity = (Message)body;
            var data = entity.getData();
            // 我都写吐了...
            // 这里可能出现的有 空对象, 空元素的集合对象, 普通的集合对象, 普通对象.
            // 找出 空对象 和 没有元素的集合对象.
            var isNullOrEmpty = ObjectUtil.isNull(data) ?
                    true : (data instanceof Collection ? ((Collection)data).isEmpty() : false);
            if(isNullOrEmpty && StrUtil.isEmpty(entity.getTips())){
                entity.setTips("No data in the return.");
            }
        }
        EventCenter.publish(new RouterCallAfter(body).setHeaders(response.getHeaders()));
        return body;
    }
}
