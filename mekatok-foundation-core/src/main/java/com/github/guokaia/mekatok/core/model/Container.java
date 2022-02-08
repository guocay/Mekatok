package com.github.guokaia.mekatok.core.model;

import java.time.LocalDateTime;

/**
 * 数据传输对象 接口
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/27
 */
public interface Container<T> {

    /**
     * 获取传输对象传输的是异常数据还是正常数据
     * @return 是否正常数据
     */
    Boolean getSuccess();

    /**
     * 获取返回时间
     * @return 返回的时间
     */
    LocalDateTime getTimestamp();
}
