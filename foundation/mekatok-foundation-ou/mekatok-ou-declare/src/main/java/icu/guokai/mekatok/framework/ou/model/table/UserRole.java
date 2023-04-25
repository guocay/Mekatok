package icu.guokai.mekatok.framework.ou.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户职位关系表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@ApiModel("用户职位关系")
@TableName("T_OU_USER_ROLE")
public class UserRole extends Table<UserRole> {

    private static final long serialVersionUID = 7210440479482324460L;

    @TableField("USER_ID")
    @ApiModelProperty("用户ID")
    private String userId;

    @TableField("ROLE_ID")
    @ApiModelProperty("职位ID")
    private String roleId;
}
