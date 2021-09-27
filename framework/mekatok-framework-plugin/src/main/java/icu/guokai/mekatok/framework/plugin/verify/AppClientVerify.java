package icu.guokai.mekatok.framework.plugin.verify;

import cn.hutool.core.util.ArrayUtil;
import icu.guokai.mekatok.framework.plugin.verify.property.Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于校验客户端IP过滤
 * 校验通过后,
 * 发布 http请求到达事件
 * 调用 请求
 * 发布 http请求结束事件
 * @author GuoKai
 * @date 2021/8/13
 */
@Slf4j
@WebFilter
@SuppressWarnings("all")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppClientVerify extends OncePerRequestFilter {

    @Autowired
    private Property property;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if(property.getEnable() && !ArrayUtil.contains(property.getClientIp(), request.getRemoteHost())){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
        filterChain.doFilter(request,response);
    }
}
