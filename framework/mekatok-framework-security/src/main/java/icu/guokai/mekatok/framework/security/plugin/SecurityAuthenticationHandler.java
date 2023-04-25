package icu.guokai.mekatok.framework.security.plugin;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理没有凭证和凭证不足的请求
 * @author GuoKai
 * @date 2021/8/18
 */
@Configuration
@SuppressWarnings("all")
public class SecurityAuthenticationHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    /**
     * http 401 在系统内的路径
     */
    private static final String UNAUTHORIZED = String.format("/%d", HttpStatus.UNAUTHORIZED.value());

    /**
     * http 403 在系统内的路径
     */
    private static final String FORBIDDEN = String.format("/%d", HttpStatus.FORBIDDEN.value());

    /**
     * HTTP 401
     * 当用户尝试访问需要权限才能用的资源而不提供Token或Token过期
     * @param request 请求对象
     * @param response 返回对象
     * @param authException 认证异常信息
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        forward(UNAUTHORIZED, request, response);
    }

    /**
     * HTTP 403
     * 当用户尝试访问需要更高的权限才时
     * @param request 请求对象
     * @param response 返回对象
     * @param accessDeniedException 权限不足异常信息
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        forward(FORBIDDEN, request, response);
    }

    /**
     * 转发请求
     * @param path 转发路径
     * @param request 请求对象
     * @param response 返回对象
     * @param accessDeniedException 权限不足异常信息
     */
    private void forward(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
