package icu.guokai.mekatok.framework.security.configure.simple;

import icu.guokai.mekatok.framework.security.configure.SecurityBasicConfiguration;
import icu.guokai.mekatok.framework.security.plugin.SecurityAuthenticationHandler;
import icu.guokai.mekatok.framework.security.plugin.SecurityAuthenticationProvider;
import icu.guokai.mekatok.framework.security.plugin.SimpleAuthenticationTokenFilter;
import icu.guokai.mekatok.framework.security.property.Property;
import icu.guokai.mekatok.framework.security.route.SimpleSecurityRouter;
import icu.guokai.mekatok.framework.security.service.SimpleSecurityUserCache;
import icu.guokai.mekatok.framework.security.service.SimpleUserDetailServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author GuoKai
 * @date 2021/8/18
 */
@Configuration
@SuppressWarnings("all")
@EnableConfigurationProperties(Property.class)
@Import({SecurityAuthenticationProvider.class, SecurityAuthenticationHandler.class, SimpleSecurityRouter.class})
public class SimpleSecurityConfiguration extends SecurityBasicConfiguration {

    /**
     * 声明用于识别和绑定Token的过滤器
     * @return Token过滤器
     */
    @Override
    protected OncePerRequestFilter getTokenFilter() {
        return new SimpleAuthenticationTokenFilter();
    }

    /**
     * 声明用户缓存管理器
     * @return 缓存管理器
     */
    @Bean
    public UserCache sceurityUserCache(){
        return new SimpleSecurityUserCache();
    }

    /**
     * 声明用户详情加载器
     * @return 用户详情加载器
     */
    @Bean
    public UserDetailsService simpleUserDetailServiceImpl(){
        return new SimpleUserDetailServiceImpl();
    }

}
