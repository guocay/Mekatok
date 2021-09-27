package icu.guokai.mekatok.framework.security.configure;

import icu.guokai.mekatok.framework.cache.redis.RedisCacheConfig;
import icu.guokai.mekatok.framework.cache.redis.deploy.RedisCacheGroup;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.swagger.SwaggerDocket;
import icu.guokai.mekatok.framework.security.plugin.SecurityAuthenticationHandler;
import icu.guokai.mekatok.framework.security.plugin.SecurityAuthenticationProvider;
import icu.guokai.mekatok.framework.security.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

import static icu.guokai.mekatok.framework.security.route.BasicSecurityRouter.CURRENT_USER_URL;
import static icu.guokai.mekatok.framework.security.route.BasicSecurityRouter.LOGOUT_URL;

/**
 * 授权配置的公用配置
 * @author GuoKai
 * @date 2021/8/18
 */
@SuppressWarnings("all")
public abstract class SecurityBasicConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private SecurityAuthenticationProvider provider;

    @Autowired
    private SecurityAuthenticationHandler handler;

    @Autowired
    private Property property;

    /**
     * 单元名称
     */
    public static final String UNIT_NAME = "security";

    /**
     * 获取需要加载的用于解析Token标识的filter
     * @return 标识过滤器
     */
    protected abstract OncePerRequestFilter getTokenFilter();

    /**
     * 注册认证逻辑
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.authenticationProvider(provider);
    }

    /**
     * 声明 认证管理器
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 设置忽略的资源
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/**/*.html", "/**/*.js",
                "/**/*.css", "/**/*.ico", "/**/*.png", "/**/*.map", "/**/*.json", "/**/*.md");
    }

    /**
     * 设置拦截逻辑配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启cors,关闭csrf
        http.cors().and().csrf().disable();

        // 防止 web 页面的 frame 被拦截
        http.headers().frameOptions().disable();

        // 不需要session(不创建会话)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 设置没有凭证时和权限补助时的处理逻辑 授权异常处理
        http.exceptionHandling().authenticationEntryPoint(handler).accessDeniedHandler(handler);

        // 设置被保护的路由
        if(property.getEnable()){
            http.authorizeRequests()
                    .antMatchers(property.getPermit()).authenticated()
                    .antMatchers(Global.BASIC_SERVICE_PATH + "/**").authenticated()
                    .antMatchers(LOGOUT_URL).authenticated()
                    .antMatchers(CURRENT_USER_URL).authenticated();
        }
        http.authorizeRequests().anyRequest().permitAll();

        // 配置登录和退出
        http.formLogin().disable()
                .httpBasic().disable()
                .logout().disable();

        // 设置用于验证和绑定Token的Filter
        http.addFilterBefore(getTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 如果存在 redis 的缓存管理器.
     * 就通过这个函数初始化用于保存用户的缓存集合
     * @return 缓存集合配置(自定义接口)
     */
    @Bean
    @ConditionalOnBean(RedisCacheConfig.class)
    public RedisCacheGroup userSingleCacheConfiguration(){
        return new RedisCacheGroup() {
            @Override
            public String getCache() {
                return Global.SECURITY_USER_CACHE;
            }

            @Override
            public Duration getTtl() {
                return Duration.ofMillis(Global.JWT_TTL);
            }
        };
    }

    /**
     * 用于定义 Security 的 swagger 定义
     */
    @Component
    class SecuritySwaggerDocket extends SwaggerDocket{

        @Override
        public String title() {
            return "用户鉴权模块";
        }

        @Override
        public String description() {
            return title() + "相关接口";
        }

        @Override
        public String authorName() {
            return Global.GK;
        }

        @Override
        public String version() {
            return Global.APPLICATION_VERSION;
        }

        @Override
        public String basePackage() {
            return String.format("%s.%s",Global.FRAMEWORK_PACKAGE_NAME,UNIT_NAME);
        }

        @Override
        public String name() {
            return UNIT_NAME;
        }
    }

}
