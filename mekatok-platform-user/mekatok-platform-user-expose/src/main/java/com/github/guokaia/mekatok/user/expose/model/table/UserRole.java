package com.github.guokaia.mekatok.user.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户角色表
 * @author GuoKai
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("用户角色表")
@TableName("T_MC_USER_ROLE")
public class UserRole extends AbstractTable<UserRole> {

    @TableField("USER_ID")
    @ApiModelProperty("用户主键")
    private String userId;

    @TableField("ROLE_ID")
    @ApiModelProperty("角色主键")
    private String roleId;
}
