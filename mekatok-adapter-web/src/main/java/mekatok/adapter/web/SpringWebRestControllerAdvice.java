package mekatok.adapter.web;

import mekatok.adapter.container.ResponseHeadBuilder;
import mekatok.core.component.container.IContainer;
import mekatok.core.component.exception.PlatformException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static mekatok.core.component.container.ContainerBuilder.builder;
import static mekatok.core.exception.Exceptions.getCode;
import static mekatok.core.exception.Exceptions.getMessage;

/**
 * Spring MVC 异常环绕处理
 * @author GuoCay
 * @since 2023.03.09
 */
@RestControllerAdvice
public class SpringWebRestControllerAdvice {

    private static final String EX_MSG_FORMAT = "%s: %s";

    @ExceptionHandler(PlatformException.class)
    public IContainer<?> exception(PlatformException ex){
        String msg = String.format(EX_MSG_FORMAT, getCode(ex.getClass(), "unknown"),
                getMessage(ex.getClass(), "unknown"));
        return builder(ResponseHeadBuilder.builder(false).mistake(msg)).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public IContainer<?> exception(RuntimeException ex){
        return builder(ResponseHeadBuilder.builder(false).mistake(ex.getMessage())).build();
    }

}
