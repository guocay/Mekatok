package com.github.guokaia.mekatok.webmvc.advice;

import com.github.guokaia.mekatok.core.exception.MekatokException;
import com.github.guokaia.mekatok.core.model.Foreign;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import com.github.guokaia.mekatok.webmvc.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 异常拦截器
 * 用于拦截在运行过程中，发生的已知和未知的所有异常。避免返回前台不友善信息.
 * 在这个类中添加拦截器的时候，一定要注意顺序。因为，异常一旦匹配后，就不会再往下处理，
 * 也就是说，越是子类，就要越靠前.
 * todo 处理逻辑还没写.
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/3
 */
@RestControllerAdvice
@Configuration(proxyBeanMethods = false)
public class WebExceptionAutoConfiguration extends AbstractRouter {

    /**
     * 应用名称
     */
    private final String applicationName;

    public WebExceptionAutoConfiguration(@Value("${spring.application.name:mekatok-application}") String applicationName) {
        this.applicationName = applicationName;
    }


    /**
     * 拦截平台内自定义异常的流程
     * @param ex 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(MekatokException.class)
    public Foreign<MekatokException> mekatokException(MekatokException ex){
        log.error(ex.getMessage(), ex);
        ServletHolder.getResponse().setStatus(HttpStatus.PRECONDITION_FAILED.value());
        return fail(ex, applicationName);
    }

    /**
     * 拦截平台内控制器参数转换异常
     * @param ex 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Foreign<MekatokException> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return mekatokException(new MekatokException(ex));
    }

    /**
     * 拦截所有异常的流程
     * @param ex 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(Exception.class)
    public Foreign<MekatokException> exception(Exception ex){
        return mekatokException(new MekatokException(ex));
    }

    /**
     * 拦截所有异常的流程
     * @param th 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(Throwable.class)
    public Foreign<MekatokException> throwable(Throwable th){
        return mekatokException(new MekatokException(th));
    }
}
