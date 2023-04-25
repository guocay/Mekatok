package mekatok.infrastructure.mo;

import mekatok.core.definition.MappedObject;

/**
 * 抽象的数据映射对象
 * @author aCay
 * @since 2023/3/6
 */
public abstract class AbstractMappedObject implements MappedObject {

    /**
     * 获取主键
     * @return 主键
     */
    abstract Long getId();

    /**
     * 修改主键
     * @param id 主键
     */
    abstract void setId(Long id);

    /**
     * 获取创建时间
     * @return 创建时间
     */
    abstract Long getCreateTime();

    /**
     * 修改创建时间
     * @param createTime 创建时间
     */
    abstract void setCreateTime(Long createTime);

    /**
     * 获取创建者
     * @return 创建者
     */
    abstract String getCreator();

    /**
     * 修改创建者
     * @param creator 创建者
     */
    abstract void setCreator(String creator);
}
