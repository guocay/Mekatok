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
 * 用户职位关系视图
 * @author GuoKai
 * @date 2021/8/19
 */
@Data
@Accessors
@ApiModel("职位权限关系视图")
@TableName("V_OU_POSITION_AUTHORITY")
public class RoleAuthorityView extends View<RoleAuthorityView> {

    private static final long serialVersionUID = -7258416288212296062L;

    @TableField("POSITION_ID")
    @ApiModelProperty("职位ID")
    private String positionId;

    @TableId("ID")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @TableField("AUTHORITY_MARK")
    @ApiModelProperty("权限标识")
    private String authorityMark;

    @TableField("AUTHORITY_MARK")
    @ApiModelProperty("数据备注")
    private String authorityNote;

}
