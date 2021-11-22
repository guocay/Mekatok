package icu.guokai.mekatok.framework.security.service;

import icu.guokai.mekatok.framework.cache.CacheCenter;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.security.user.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户本地缓存的实现 - 简单登录
 * @author GuoKai
 * @date 2021/8/18
 */
@Slf4j
@SuppressWarnings("all")
public class SimpleSecurityUserCache implements UserCache {

    /**
     * 获取用户通过缓存
     * @param username 用户名
     * @return 用户详情
     */
    @Override
    public SecurityUser getUserFromCache(String username) {
        return CacheCenter.get(Global.SECURITY_USER_CACHE, username, SecurityUser.class);
    }

    /**
     * 用户详情放入缓存
     * @param user 用户详情
     */
    @Override
    public void putUserInCache(UserDetails user) {
        log.info("正在尝试将已认证用户 {} 放入登录缓存中.", user.getUsername());
        CacheCenter.put(Global.SECURITY_USER_CACHE, user.getUsername(), user);
    }

    /**
     * 用户详情移出缓存
     * @param username 用户名
     */
    @Override
    public void removeUserFromCache(String username) {
        log.info("正在尝试将已认证用户 {} 移出登录缓存中.", username);
        CacheCenter.evict(Global.SECURITY_USER_CACHE, username);
    }

    /**
     * 验证用户是否存在缓存,存在则意味着用户已登录.
     * @param username 用户名
     * @return 是否存在
     */
    public Boolean containsKey(String username){
        return CacheCenter.exist(Global.SECURITY_USER_CACHE, username);
    }
}
