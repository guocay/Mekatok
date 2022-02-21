package com.github.guokaia.mekatok.common.foreign;

import com.github.guokaia.mekatok.core.exception.ExceptionDefinition;
import com.github.guokaia.mekatok.core.exception.MekatokException;
import com.github.guokaia.mekatok.core.model.Foreign;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * 异常容器信息
 * @author GuoKai
 * @date 2022/2/4
 */
@Data
public class GeneralForeign<Exception extends MekatokException> implements Foreign<Exception> {

    /**
     * 返回异常容器对象代表操作不成功
     */
    private Boolean success = Boolean.FALSE;

    /**
     * 异常编码
     */
    private String code;

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 当前时间
     */
    private LocalDateTime timestamp;

    /**
     * 错误信息由哪个服务返回
     */
    private String server;

    @SuppressWarnings("unchecked")
    public GeneralForeign(){
        this((Exception) new MekatokException());
    }

    public GeneralForeign(Exception exception){
        this(exception, HttpStatus.PRECONDITION_FAILED);
    }

    public GeneralForeign(Exception exception, HttpStatus httpStatus){
        this.status = httpStatus.value();
        this.timestamp = LocalDateTime.now();
        this.code = code(exception);
        this.message = message(exception);
    }

    /**
     * 静态方法 构建 异常返回对象
     * @param exception 异常
     * @param <Exception> 类型
     * @return 异常返回对象
     */
    public static <Exception extends MekatokException> GeneralForeign<Exception> of(Exception exception){
        return new GeneralForeign<>(exception);
    }

    /**
     * 静态方法 构建 异常返回对象
     * @param exception 异常
     * @param httpStatus Http状态码
     * @param <Exception> 类型
     * @return 异常返回对象
     */
    public static <Exception extends MekatokException> GeneralForeign<Exception> of(Exception exception, HttpStatus httpStatus){
        return new GeneralForeign<>(exception, httpStatus);
    }

    /**
     * 构建异常的代码信息
     * @param exception 异常
     * @return 代码信息
     */
    private String code(Exception exception) {
        Class<? extends MekatokException> clazz = exception.getClass();
        String code = clazz.getCanonicalName();
        ExceptionDefinition definition = clazz.getAnnotation(ExceptionDefinition.class);
        if (Objects.nonNull(definition)){
            code = definition.code();
        }
        return code;
    }

    /**
     * 构建异常的提示信息
     * @param exception 异常
     * @return 提示信息
     */
    private String message(Exception exception) {
        return Optional.ofNullable(exception.getMessage()).orElseGet(() -> {
                    ExceptionDefinition definition = exception.getClass().getAnnotation(ExceptionDefinition.class);
                    return Objects.isNull(definition) ? "" : definition.message();
                });
    }

}
