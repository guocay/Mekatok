package com.github.guokaia.mekatok.core.model.store;

import java.time.LocalDateTime;

/**
 * 平台内 所有数据库表映射的接口
 * @author GuoKai
 * @date 2022/1/27
 */
public interface Table<T extends Table<T>> extends View<T>{

    /**
     * 获取主键
     * @return 主键
     */
    String getId();

    /**
     * 修改主键
     * @param id 唯一标识
     * @return 当前对象
     */
    T setId(String id);

    /**
     * 获取数据状态
     * @return 数据状态
     */
    Boolean getDataStatus();

    /**
     * 设置数据状态
     * @param dataStatus 数据状态
     * @return 当前对象
     */
    T setDataStatus(Boolean dataStatus);

    /**
     * 获取创建者
     * @return 创建者
     */
    String getCreator();

    /**
     * 设置创建者
     * @param creator 创建者
     * @return 当前对象
     */
    T setCreator(String creator);

    /**
     * 获取创建时间
     * @return 创建时间
     */
    LocalDateTime getCreateTime();

    /**
     * 设置创建时间
     * @param createTime 创建时间
     * @return 当前对象
     */
    T setCreateTime(LocalDateTime createTime);

    /**
     * 获取更新者
     * @return 更新者
     */
    String getUpdater();

    /**
     * 设置更新者
     * @param updater 更新者
     * @return 当前对象
     */
    T setUpdater(String updater);

    /**
     * 获取更新时间
     * @return 更新时间
     */
    LocalDateTime getUpdateTime();

    /**
     * 设置更新时间
     * @param updateTime 更新时间
     * @return 当前对象
     */
    T setUpdateTime(LocalDateTime updateTime);

}
