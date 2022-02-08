package com.github.guokaia.mekatok.user.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色表
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("角色表")
@TableName("T_MC_ROLE")
public class Role extends AbstractTable<Role> {

    @TableField("MARK")
    @ApiModelProperty("标识")
    private String mark;

    @TableField("REMARK")
    @ApiModelProperty("备注")
    private String remark;

}
