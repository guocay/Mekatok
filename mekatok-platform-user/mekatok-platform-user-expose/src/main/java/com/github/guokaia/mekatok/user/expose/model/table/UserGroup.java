package com.github.guokaia.mekatok.user.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户组织表
 * @author GuoKai
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("用户组织表")
@TableName("T_MC_USER_GROUP")
public class UserGroup extends AbstractTable<UserGroup> {

    @TableField("USER_ID")
    @ApiModelProperty("用户主键")
    private String userId;

    @TableField("GROUP_ID")
    @ApiModelProperty("组织主键")
    private String groupId;
}
