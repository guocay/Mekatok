package icu.guokai.mekatok.framework.security.plugin;

import icu.guokai.mekatok.framework.core.constant.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 身份验证提供者
 * @author GuoKai
 * @date 2021/8/18
 */
@Configuration
@SuppressWarnings("all")
public class SecurityAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserDetailsService service;

    @Autowired
    private UserCache cache;

    /**
     * 初始化前的操作
     */
    @Override
    protected void doAfterPropertiesSet() {
        setUserCache(cache);
        setPasswordEncoder(Global.ENCODER);
        setUserDetailsService(service);
        setHideUserNotFoundExceptions(false);
        super.doAfterPropertiesSet();
    }

    /**
     * 登录逻辑
     * @param authentication 验证逻辑
     * @return 认证对象
     * @throws AuthenticationException 认证异常
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return super.authenticate(authentication);
    }

    /**
     * 密码验证逻辑
     * @param userDetails 用户详情
     * @param authentication 认证对象
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        super.additionalAuthenticationChecks(userDetails, authentication);
    }

    /**
     * 判断是否由当前类处理认证
     * @param authentication 认证对象
     * @return 是否执行
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return super.supports(authentication);
    }
}
