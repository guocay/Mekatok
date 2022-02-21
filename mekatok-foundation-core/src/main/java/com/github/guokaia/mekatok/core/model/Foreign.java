package com.github.guokaia.mekatok.core.model;

import com.github.guokaia.mekatok.core.exception.MekatokException;

/**
 * 传输对象中的异常载体
 * @author GuoKai
 * @date 2022/1/27
 */
public interface Foreign<ExceptionClass extends MekatokException> extends Container<ExceptionClass> {

    /**
     * 获取编码
     * @return 编码
     */
    String getCode();

    /**
     * 获取提示文本
     * @return 提示文本
     */
    String getMessage();

    /**
     * 获取错误来自哪个服务器
     * @return 服务名称
     */
    String getServer();
}
