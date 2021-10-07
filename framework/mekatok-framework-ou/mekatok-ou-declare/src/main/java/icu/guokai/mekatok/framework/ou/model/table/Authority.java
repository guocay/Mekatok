package icu.guokai.mekatok.framework.ou.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 权限表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@ApiModel("权限对象")
@TableName("T_OU_AUTHORITY")
public class Authority extends Table<Authority> {

    private static final long serialVersionUID = 5943947670255243021L;

    @TableField("MARK")
    @ApiModelProperty("权限标识")
    private String mark;

    @TableField("NOTE")
    @ApiModelProperty("数据备注")
    private String note;
}
