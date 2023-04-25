package icu.guokai.mekatok.framework.ou.model.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.View;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户组织关系视图
 * @author GuoKai
 * @date 2021/8/19
 */
@Data
@Accessors
@ApiModel("用户组织关系视图")
@TableName("V_OU_USER_ORGANIZE")
public class UserOrganizeView extends View<UserOrganizeView> {

    private static final long serialVersionUID = -2431330348070789455L;

    @TableField("USER_ID")
    @ApiModelProperty("用户ID")
    private String userId;

    @TableId("ID")
    @ApiModelProperty(value = "数据主键")
    private String id;

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
