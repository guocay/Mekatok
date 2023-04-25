package icu.guokai.mekatok.framework.security.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReflectUtil;
import icu.guokai.mekatok.framework.ou.model.table.User;
import icu.guokai.mekatok.framework.ou.service.IUserService;
import icu.guokai.mekatok.framework.security.user.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 简单登录的用户的获取服务
 * @author GuoKai
 * @date 2021/8/18
 */
@SuppressWarnings("all")
public class SimpleUserDetailServiceImpl implements UserDetailsService {

    /**
     * 用户服务
     */
    @Autowired
    private IUserService userService;

    /**
     * 根据用户名加载用户
     * @param username 用户名
     * @return 用户详情
     * @throws UsernameNotFoundException 用户未找到
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUser(username);
    }

    /**
     * 根据用户表加载安全用户信息
     * @param user 用户表
     * @return 安全用户
     */
    private SecurityUser loadUser(String username){
        var user = ReflectUtil.newInstance(User.class).setLoginName(username).queryUser();
        var userId = user.getId();
        return SecurityUser.of(user,
                CollUtil.newHashSet(userService.queryAuthorityById(userId)),
                CollUtil.newHashSet(userService.queryOrganizeById(userId)),
                CollUtil.newHashSet(userService.queryPositionById(userId))
        );
    }
}
