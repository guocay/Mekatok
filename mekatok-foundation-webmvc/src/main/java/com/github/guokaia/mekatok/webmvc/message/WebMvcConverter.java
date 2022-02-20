package com.github.guokaia.mekatok.webmvc.message;

import com.github.guokaia.mekatok.common.foreign.GeneralForeign;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.common.model.PackingBoolean;
import com.github.guokaia.mekatok.common.model.PackingChar;
import com.github.guokaia.mekatok.common.model.PackingNumber;
import com.github.guokaia.mekatok.core.exception.MekatokException;
import com.github.guokaia.mekatok.core.message.Converter;
import com.github.guokaia.mekatok.core.model.Packing;

/**
 * 平台内用于返回WebMvcMessageSupport的扩展支持
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public interface WebMvcConverter extends Converter {

    /**
     * 返回成功
     * RouterMessageConverter
     * @param <T> 泛型
     * @param bean 返回数据
     * @return 传输容器
     */
    default <T extends Packing<T>> GeneralPaging<T> success(T bean){
        return GeneralPaging.of(bean);
    }

    /**
     * 发送字符类型数据
     * @param message 内容
     * @return 传输容器
     */
    default <T extends CharSequence> GeneralPaging<PackingChar<T>> success(T message){
        return success(new PackingChar<T>(message));
    }

    /**
     * 发送数字类型数据
     * @param message 内容
     * @return 传输容器
     */
    default <T extends Number> GeneralPaging<PackingNumber<T>> success(T message){
        return success(new PackingNumber<T>(message));
    }

    /**
     * 发送布尔类型数据
     * @param message 内容
     * @return 传输容器
     */
    default GeneralPaging<PackingBoolean> success(Boolean message){
        return success(new PackingBoolean(message));
    }

    /**
     * 发送错误数据
     * @param exception 错误信息
     * @param <T> 错误泛型
     * @return 异常传输容器
     */
    default <T extends MekatokException> GeneralForeign<T> fail(T exception){
        return fail(exception, null);
    }

    /**
     * 发送错误数据
     * @param exception 错误信息
     * @param server 服务名称
     * @param <T> 错误泛型
     * @return 异常传输容器
     */
    default <T extends MekatokException> GeneralForeign<T> fail(T exception, String server){
        GeneralForeign<T> foreign = GeneralForeign.of(exception);
        return foreign.setServer(server);
    }

}
