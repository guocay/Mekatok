package icu.guokai.mekatok.framework.plugin.advice;

import icu.guokai.mekatok.framework.core.event.EventCenter;
import icu.guokai.mekatok.framework.core.message.Message;
import icu.guokai.mekatok.framework.core.message.support.WebMvcMessageSupport;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.UnExpectedException;
import icu.guokai.mekatok.framework.plugin.event.RouterCallMistake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常拦截器
 * 用于拦截在运行过程中，发生的已知和未知的所有异常。避免返回前台部友善信息。
 * 在这个类中添加拦截器的时候，一定要注意顺序。因为，异常一旦匹配后，就不会再往下处理，
 * 也就是说，越是子类，就要越靠前。
 * @author GuoKai
 * @date 2021/8/13
 */
@Slf4j
@RestControllerAdvice
@SuppressWarnings("rawtypes")
public class WebMvcExceptionAdvice implements WebMvcMessageSupport {

    /**
     * 拦截平台内自定义异常的流程
     * @param ex 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(MekatokException.class)
    public ResponseEntity<Message> mekatokException(MekatokException ex){
        EventCenter.publish(new RouterCallMistake(ex));
        return failure(ex);
    }

    /**
     * 拦截所有异常的流程
     * @param th 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Message> exception(Throwable th){
        EventCenter.publish(new RouterCallMistake(th));
        return failure(new UnExpectedException(th.getMessage()));
    }
}
