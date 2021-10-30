package icu.guokai.mekatok.framework.ou.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 组织用户关系表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@ApiModel("组织用户关系")
@TableName("T_OU_USER_ORGANIZE")
public class UserOrganize extends Table<UserOrganize> {

    private static final long serialVersionUID = -3263116417312772921L;

    @TableField("USER_ID")
    @ApiModelProperty("用户ID")
    private String userId;

    @TableField("ORGANIZE_ID")
    @ApiModelProperty("组织ID")
    private String organizeId;
}
