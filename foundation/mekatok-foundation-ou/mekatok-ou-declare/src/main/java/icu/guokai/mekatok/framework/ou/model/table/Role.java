package icu.guokai.mekatok.framework.ou.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 职位表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@NoArgsConstructor
@ApiModel("职位对象")
@TableName("T_OU_ROLE")
public class Role extends Table<Role> {

    private static final long serialVersionUID = -7467457571179430709L;

    @TableField("CODE")
    @ApiModelProperty("编码")
    private String code;

    @TableField("NAME")
    @ApiModelProperty("名称")
    private String name;

    @TableField("REMARK")
    @ApiModelProperty("备注")
    private String remark;
}
