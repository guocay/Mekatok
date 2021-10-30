package icu.guokai.mekatok.framework.core.http;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestCookie;
import com.dtflys.forest.http.ForestCookies;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.interceptor.InterceptorAttributes;
import com.dtflys.forest.reflection.ForestMethod;
import com.dtflys.forest.utils.ForestProgress;
import icu.guokai.mekatok.framework.core.collect.ArrayMultiMap;
import icu.guokai.mekatok.framework.core.collect.MultiMap;

import java.util.List;

/**
 * forest 环绕工具拦截器
 * 请求的全生命周期
 * @author GuoKai
 * @date 2021/10/30
 */
public class HttpInterceptor<T> implements Interceptor<T> {

    /**
     * Cookie在本地存储的缓存
     */
    private MultiMap<String,ForestCookie> cookieCache = ArrayMultiMap.<String,ForestCookie>create();

    @Override
    public void onInvokeMethod(ForestRequest request, ForestMethod method, Object[] args) {
        Interceptor.super.onInvokeMethod(request, method, args);
    }

    @Override
    public boolean beforeExecute(ForestRequest request) {
        return Interceptor.super.beforeExecute(request);
    }

    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        Interceptor.super.afterExecute(request, response);
    }

    @Override
    public void onSuccess(T data, ForestRequest request, ForestResponse response) {
        Interceptor.super.onSuccess(data, request, response);
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        Interceptor.super.onError(ex, request, response);
    }

    @Override
    public void onRetry(ForestRequest request, ForestResponse response) {
        Interceptor.super.onRetry(request, response);
    }

    @Override
    public void onProgress(ForestProgress progress) {
        Interceptor.super.onProgress(progress);
    }

    @Override
    public void onRedirection(ForestRequest<?> redirectReq, ForestRequest<?> prevReq, ForestResponse<?> prevRes) {
        Interceptor.super.onRedirection(redirectReq, prevReq, prevRes);
    }

    @Override
    public void onLoadCookie(ForestRequest request, ForestCookies cookies) {
        // 获取请求URI的主机名
        String host = request.getURI().getHost();
        // 从缓存中获取之前获得的Cookie列表，主机名作为Key
        List<ForestCookie> cookieList = (List<ForestCookie>) cookieCache.get(host);
        // 将缓存中的Cookie列表添加到请求Cookie列表中，准备发送到服务端
        cookies.addAllCookies(cookieList);
    }

    @Override
    public void onSaveCookie(ForestRequest request, ForestCookies cookies) {
        // 获取请求URI的主机名
        String host = request.getURI().getHost();
        // 将从服务端获得的Cookie列表放入缓存，主机名作为Key
        cookieCache.put(host, cookies.allCookies());
    }

    @Override
    public InterceptorAttributes getAttributes(ForestRequest request) {
        return Interceptor.super.getAttributes(request);
    }

    @Override
    public void addAttribute(ForestRequest request, String name, Object value) {
        Interceptor.super.addAttribute(request, name, value);
    }

    @Override
    public Object getAttribute(ForestRequest request, String name) {
        return Interceptor.super.getAttribute(request, name);
    }

    @Override
    public <T1> T1 getAttribute(ForestRequest request, String name, Class<T1> clazz) {
        return Interceptor.super.getAttribute(request, name, clazz);
    }

    @Override
    public String getAttributeAsString(ForestRequest request, String name) {
        return Interceptor.super.getAttributeAsString(request, name);
    }

    @Override
    public Integer getAttributeAsInteger(ForestRequest request, String name) {
        return Interceptor.super.getAttributeAsInteger(request, name);
    }

    @Override
    public Float getAttributeAsFloat(ForestRequest request, String name) {
        return Interceptor.super.getAttributeAsFloat(request, name);
    }

    @Override
    public Double getAttributeAsDouble(ForestRequest request, String name) {
        return Interceptor.super.getAttributeAsDouble(request, name);
    }
}
