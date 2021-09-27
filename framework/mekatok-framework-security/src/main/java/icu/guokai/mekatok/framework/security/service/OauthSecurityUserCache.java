package icu.guokai.mekatok.framework.security.service;

import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户本地缓存的实现 - 外部认证
 * @author GuoKai
 * @date 2021/8/18
 */
public class OauthSecurityUserCache implements UserCache {

    /**
     * 获取用户通过缓存
     * @param username 用户名
     * @return 用户详情
     */
    @Override
    public UserDetails getUserFromCache(String username) {
        return null;
    }

    /**
     * 用户详情放入缓存
     * @param user 用户详情
     */
    @Override
    public void putUserInCache(UserDetails user) {

    }

    /**
     * 用户详情移出缓存
     * @param username 用户名
     */
    @Override
    public void removeUserFromCache(String username) {

    }
}
