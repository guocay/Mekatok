package icu.guokai.mekatok.framework.ou.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 职位权限关系表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@ApiModel("职位权限关系")
@TableName("T_OU_ROLE_AUTHORITY")
public class RoleAuthority extends Table<RoleAuthority> {

    private static final long serialVersionUID = -3160665399975749729L;

    @TableField("ROLE_ID")
    @ApiModelProperty("职位ID")
    private String roleId;

    @TableField("AUTHORITY_ID")
    @ApiModelProperty("权限ID")
    private String authorityId;
}
