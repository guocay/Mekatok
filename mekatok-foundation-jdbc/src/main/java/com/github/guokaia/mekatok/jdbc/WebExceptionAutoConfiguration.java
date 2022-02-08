package com.github.guokaia.mekatok.jdbc;

import com.github.guokaia.mekatok.core.exception.MekatokException;
import com.github.guokaia.mekatok.core.model.Foreign;
import com.github.guokaia.mekatok.jdbc.exception.DatabaseException;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import com.github.guokaia.mekatok.webmvc.servlet.ServletHolder;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * JDBC 的 WEBMVC异常拦截器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@RestControllerAdvice
@Configuration(proxyBeanMethods = false)
public class WebExceptionAutoConfiguration extends AbstractRouter {

    /**
     * 拦截所有异常的流程
     * @param ex 异常内容
     * @return 返回消息
     */
    @ExceptionHandler(PersistenceException.class)
    public Foreign<MekatokException> exception(PersistenceException ex){
        log.error(ex.getMessage(), ex);
        ServletHolder.getResponse().setStatus(HttpStatus.PRECONDITION_FAILED.value());
        return fail(new DatabaseException("MyBatis 持久化异常", ex));
    }
}
