package icu.guokai.mekatok.framework.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 外部认证服务器获取用户的方法
 * @author GuoKai
 * @date 2021/8/18
 */
public class OauthUserDetailServiceImpl implements UserDetailsService {

    /**
     * 根据标识获取用户资源
     * @param tokean 标识
     * @return 安全用户
     * @throws UsernameNotFoundException 用户未找到异常
     */
    @Override
    public UserDetails loadUserByUsername(String tokean) throws UsernameNotFoundException {
        return null;
    }
}
