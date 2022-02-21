package com.github.guokaia.mekatok.common.model.store;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.guokaia.mekatok.core.model.store.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 抽象的数据库映射对象,平台内的数据库映射对象均需要实现这个方法.<br/>
 * 表名定义: T_{ModuleName}_{DomainName}
 * <li>ModuleName ~ MC: ModuleName 模块核心</li>
 * @author GuoKai
 * @date 2022/2/3
 */
@SuppressWarnings("all")
@Getter
public class AbstractTable<T extends AbstractTable<T>> implements Table<T> {

    @TableId("ID")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @TableLogic
    @JsonIgnore
    @ApiModelProperty(value = "数据状态",hidden = true)
    @TableField(value = "DATA_STATUS",select = false,fill= FieldFill.INSERT_UPDATE)
    private Boolean dataStatus;

    @JsonIgnore
    @ApiModelProperty(value = "创建者",hidden = true)
    @TableField(value = "CREATOR",select = false,fill= FieldFill.INSERT)
    private String creator;

    @JsonIgnore
    @ApiModelProperty(value = "更新者",hidden = true)
    @TableField(value = "UPDATER",select = false,fill= FieldFill.INSERT_UPDATE)
    private String updater;

    @JsonIgnore
    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField(value = "CREATE_TIME",select = false,fill= FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonIgnore
    @ApiModelProperty(value = "更新时间",hidden = true)
    @TableField(value = "UPDATE_TIME",select = false,fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Override
    public T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @Override
    public T setDataStatus(Boolean dataStatus) {
        this.dataStatus = dataStatus;
        return (T) this;
    }

    @Override
    public T setCreator(String creator) {
        this.creator = creator;
        return (T) this;
    }

    @Override
    public T setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return (T) this;
    }

    @Override
    public T setUpdater(String updater) {
        this.updater = updater;
        return (T) this;
    }

    @Override
    public T setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return (T) this;
    }

}
