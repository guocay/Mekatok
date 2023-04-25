package icu.guokai.mekatok.framework.security.plugin;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于验证并绑定已登录信息 - 外部认证服务登录
 * @author GuoKai
 * @date 2021/8/18
 */
public class OauthAuthenticationTokenFilter extends OncePerRequestFilter {

    /**
     * 拦截所有的请求,根据规则获取登录信息绑定至线程.
     * @param request 请求对象
     * @param response 返回对象
     * @param filterChain filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        filterChain.doFilter(request,response);
    }
}
