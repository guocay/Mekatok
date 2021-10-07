package icu.guokai.mekatok.framework.ou.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 组织表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@ApiModel("组织对象")
@TableName("T_OU_ORGANIZE")
public class Organize extends Table<Organize> {

    private static final long serialVersionUID = -7841271017118120361L;

    @TableField("PARENT")
    @ApiModelProperty(value = "父级",notes = "存的是id,不是code.")
    private String parent;

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
