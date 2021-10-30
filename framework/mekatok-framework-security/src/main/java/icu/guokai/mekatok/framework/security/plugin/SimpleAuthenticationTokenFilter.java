package icu.guokai.mekatok.framework.security.plugin;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.jwt.JwtCenter;
import icu.guokai.mekatok.framework.security.service.SimpleSecurityUserCache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于验证并绑定已登录信息 - 简单登录
 * @author GuoKai
 * @date 2021/8/18
 */
public class SimpleAuthenticationTokenFilter extends OncePerRequestFilter {


    /**
     * 拦截所有的请求,根据规则获取登录信息绑定至线程.
     * @param request 请求对象
     * @param response 返回对象
     * @param filterChain filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token, username;
        // 获取用户登录缓存
        var cache = SpringUtil.getBean(SimpleSecurityUserCache.class);
        // 验证Token, 并绑定至 SecurityContextHolder 对象上
        if(StrUtil.isNotBlank(token = request.getHeader(Global.JWT_TOKEN))
                && StrUtil.isNotBlank(username = JwtCenter.getSubjectByToken(token))
                && cache.containsKey(username)){
            var user = cache.getUserFromCache(username);
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities()));
        }
        filterChain.doFilter(request,response);
    }
}
