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
 * 用户权限关系视图
 * @author GuoKai
 * @date 2021/8/19
 */
@Data
@Accessors
@ApiModel("用户权限关系视图")
@TableName("V_OU_USER_AUTHORITY")
public class UserAuthorityView extends View<UserAuthorityView> {

    private static final long serialVersionUID = -4696615978170283925L;

    @TableField("USER_ID")
    @ApiModelProperty("用户ID")
    private String userId;

    @TableId("ID")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @TableField("MARK")
    @ApiModelProperty("权限标识")
    private String mark;

    @TableField("NOTE")
    @ApiModelProperty("数据备注")
    private String note;

}
