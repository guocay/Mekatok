package com.github.guokaia.mekatok.user.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色权力表
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("角色权力表")
@TableName("T_MC_ROLE_POWER")
public class RolePower extends AbstractTable<RolePower> {

    @TableField("ROLE_ID")
    @ApiModelProperty("角色主键")
    private String roleId;

    @TableField("POWER_ID")
    @ApiModelProperty("权力主键")
    private String powerId;

}
