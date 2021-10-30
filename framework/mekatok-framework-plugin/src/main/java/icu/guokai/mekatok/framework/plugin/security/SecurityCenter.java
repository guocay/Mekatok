package icu.guokai.mekatok.framework.plugin.security;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 在当前线程中获取用户信息.
 * @author GuoKai
 * @date 2021/02/20
 */
@SuppressWarnings("unchecked")
public abstract class SecurityCenter {

    private static final String USER_ID_FIELD = "userId";

    /**
     * 获取用户登录凭证
     * @return 用户凭证
     */
    public static Authentication getAuthentication(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication instanceof UsernamePasswordAuthenticationToken ? authentication : null;
    }

    /**
     * 获取UserDetails信息
     * @return 用户信息
     */
    public static UserDetails getUserDetails(){
        var authentication = getAuthentication();
        return authentication == null ? null : (UserDetails) authentication.getPrincipal();
    }

    /**
     * 获取当前登录用户Id
     * @return 用户ID
     */
    public static String getUserId(){
        var user = getUserDetails();
        return user == null ? null : (String) ReflectUtil.getFieldValue(user,USER_ID_FIELD);
    }

    /**
     * 获取当前登录用户登录名
     * @return 用户名
     */
    public static String getLoginName(){
        var authentication = getAuthentication();
        return authentication == null ? null : authentication.getName();
    }

}
