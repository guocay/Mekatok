package com.github.guokaia.mekatok.auth.expose.model.packing;

import com.github.guokaia.mekatok.core.model.Packing;
import com.github.guokaia.mekatok.user.expose.model.table.Group;
import com.github.guokaia.mekatok.user.expose.model.table.Power;
import com.github.guokaia.mekatok.user.expose.model.table.Role;
import com.github.guokaia.mekatok.user.expose.model.table.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 安全用户
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/7
 */
@Data
@Accessors
@ApiModel("安全用户")
@AllArgsConstructor
public class SecurityUser implements Packing<SecurityUser> {

    @ApiModelProperty("用户")
    private User user;

    @ApiModelProperty("分组")
    private List<Group> groups;

    @ApiModelProperty("角色")
    private List<Role> roles;

    @ApiModelProperty("权力")
    private List<Power> powers;

}
