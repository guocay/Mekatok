package com.github.guokaia.mekatok.webmvc.servlet;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Objects;

/**
 * Web Servlet 相关静态工具类
 * @author GuoKai
 * @date 2022/2/1
 */
public class ServletHolder {

    private ServletHolder(){}

    /**
     * 获取ServletRequestAttributes
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getAttributes(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Objects.requireNonNull(attributes,"ServletRequestAttributes 对象为空!");
        return attributes;
    }

    /**
     * 获取 HttpServletRequest 请求对象
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest(){
        return getAttributes().getRequest();
    }

    /**
     * 获取 HttpServletResponse 响应对象
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse(){
        return getAttributes().getResponse();
    }

    /**
     * 忽略大小写获得请求header中的信息
     * @param request        请求对象{@link HttpServletRequest}
     * @param nameIgnoreCase 忽略大小写头信息的KEY
     * @return header值
     */
    public static String getHeaderIgnoreCase(HttpServletRequest request, String nameIgnoreCase) {
        final Enumeration<String> names = request.getHeaderNames();
        String name;
        while (names.hasMoreElements()) {
            name = names.nextElement();
            if (name != null && name.equalsIgnoreCase(nameIgnoreCase)) {
                return request.getHeader(name);
            }
        }
        return null;
    }

    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static String getHeader(String name){
        return getHeaderIgnoreCase(getRequest(),name);
    }

    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Long getHeaderWithLong(String name){
        String value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Long.parseLong(value) : null;
    }

    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Integer getHeaderWithInt(String name){
        String value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Integer.parseInt(value) : null;
    }

    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Double getHeaderWithDouble(String name){
        String value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Double.parseDouble(value) : null;
    }

    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Boolean getHeaderWithBoolean(String name){
        String value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Boolean.parseBoolean(value) : null;
    }

    /**
     * 获取请求服务的客户端IP地址.
     * @return IP地址
     */
    public static String getRemoteAddr() {
        return getRequest().getRemoteAddr();
    }

}
