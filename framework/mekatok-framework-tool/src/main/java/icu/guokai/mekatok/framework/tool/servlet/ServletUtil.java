package icu.guokai.mekatok.framework.tool.servlet;

import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author GuoKai
 * @date 2021/8/13
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServletUtil extends cn.hutool.extra.servlet.ServletUtil {

    /**
     * 获取ServletRequestAttributes
     * @return ServletRequestAttributes
     */
    private static ServletRequestAttributes getAttributes(){
        var attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
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
        var value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Long.parseLong(value) : null;
    }

    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Integer getHeaderWithInt(String name){
        var value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Integer.parseInt(value) : null;
    }


    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Double getHeaderWithDouble(String name){
        var value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Double.parseDouble(value) : null;
    }


    /**
     * 获取 header 内指定信息的第一个元素值
     * @param name header key
     * @return header value
     */
    public static Boolean getHeaderWithBoolean(String name){
        var value = getHeader(name);
        return StrUtil.isNotEmpty(value) ? Boolean.parseBoolean(value) : null;
    }
}
