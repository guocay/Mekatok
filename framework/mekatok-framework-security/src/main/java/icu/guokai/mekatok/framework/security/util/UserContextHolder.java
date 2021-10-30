package icu.guokai.mekatok.framework.security.util;

import icu.guokai.mekatok.framework.ou.model.view.UserOrganizeView;
import icu.guokai.mekatok.framework.plugin.security.SecurityCenter;
import icu.guokai.mekatok.framework.security.user.SecurityUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * 在当前线程中获取用户信息.
 * 比plugin模块的更接近应用层
 * @author GuoKai
 * @date 2021/8/18
 */
@SuppressWarnings("all")
public abstract class UserContextHolder extends SecurityCenter {

    /**
     * 获取当前登录用户的权限信息
     * @return 权限集合
     */
    public static Set<GrantedAuthority> getAuthorities(){
        var user = (SecurityUser) getUserDetails();
        return user == null ? null : user.getAuthorities();
    }

    /**
     * 获取当前登录用户的组织信息
     * @return 组织信息
     */
    public static Set<UserOrganizeView> getOrganizes(){
        var user =  (SecurityUser) getUserDetails();
        return user == null ? null : user.getOrganizes();
    }
}
