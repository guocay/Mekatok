package icu.guokai.mekatok.framework.security.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import icu.guokai.mekatok.framework.ou.model.table.User;
import icu.guokai.mekatok.framework.ou.model.view.UserAuthorityView;
import icu.guokai.mekatok.framework.ou.model.view.UserOrganizeView;
import icu.guokai.mekatok.framework.ou.model.view.UserRoleView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 安全用户对象
 * @author GuoKai
 * @date 2021/8/18
 */
@Data
@Accessors
@NoArgsConstructor
@ApiModel("安全用户")
public class SecurityUser implements UserDetails {

    private static final long serialVersionUID = 102757422419188516L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户主键")
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty("登录名称")
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 权限集合
     */
    @ApiModelProperty("权限集合")
    private Set<GrantedAuthority> authorities;

    /**
     * 部门集合
     */
    @ApiModelProperty("组织集合")
    private Set<UserOrganizeView> organizes;

    /**
     * 职位集合
     */
    @ApiModelProperty("职位集合")
    private Set<UserRoleView> roles;

    /**
     * 是否用户过期
     */
    @ApiModelProperty("用户过期")
    private boolean accountNonExpired;

    /**
     * 是否账户锁定
     */
    @ApiModelProperty("账户锁定")
    private boolean accountNonLocked;

    /**
     * 是否凭证过期
     */
    @ApiModelProperty("凭证过期")
    private boolean credentialsNonExpired;

    /**
     * 是否启用
     */
    @ApiModelProperty("用户启用")
    private boolean enabled;

    /**
     * 构造器
     * @param user 用户表
     * @param authorities 权限表
     * @param organizes 组织表
     * @param roles 职位表
     */
    public SecurityUser(User user, Set<UserAuthorityView> authorities,
                        Set<UserOrganizeView> organizes, Set<UserRoleView> roles){
        this.userId = user.getId();
        this.username = user.getLoginName();
        this.password = user.getPassword();
        this.organizes = organizes;
        this.roles = roles;
        this.enabled = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.authorities = Optional.ofNullable(authorities).orElse(Set.of())
                .stream().parallel()
                .map(UserAuthorityView::getMark)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    /**
     * 静态工厂 - 构造函数
     * @param user 用户表
     * @param authorities 权限表
     * @param organizes 组织表
     * @param roles 职位表
     * @return 安全用户
     */
    public static SecurityUser of(User user,Set<UserAuthorityView> authorities,Set<UserOrganizeView> organizes, Set<UserRoleView> roles){
        return new SecurityUser(user,authorities,organizes,roles);
    }
}
