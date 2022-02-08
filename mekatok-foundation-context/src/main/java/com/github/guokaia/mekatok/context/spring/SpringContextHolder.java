package com.github.guokaia.mekatok.context.spring;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.core.exception.MekatokException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

/**
 * Spring 工具类<br/>
 * 这是一个静态工具类, 请勿实例化使用.
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/26
 */
@SuppressWarnings("all")
public class SpringContextHolder implements ApplicationContextAware {

    /**
     * 平台内日期时间相关类的参数标记
     */
    private static final String JSON_FORMAT_TIME_MARK = "mekatok.json-format.time";
    private static final String JSON_FORMAT_DATA_MARK = "mekatok.json-format.date";
    private static final String JSON_FORMAT_DATATIME_MARK = "mekatok.json-format.data-time";

    /**
     * 应用上下文
     */
    private static ApplicationContext applicationContext;

    /**
     * 私有化构造器
     */
    private SpringContextHolder(){}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取应用上下文
     * @return 应用上下文
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 发布应用事件
     * @param event 事件
     */
    public static void publishEvent(Object event){
        applicationContext.publishEvent(event);
    }

    /**
     * 获取环境变量配置
     * @return 环境变量
     */
    public static Environment getEnvironment(){
        return applicationContext.getEnvironment();
    }

    /**
     * 获取 Environment 中的值
     * @param key 键
     * @return 环境变量中的值
     */
    public static String getProperty(String key){
        return getProperty(key, String.class, null);
    }

    /**
     * 获取 Environment 中的值
     * @param key 键
     * @param defaultValue 为空时的默认值
     * @return 环境变量中的值
     */
    public static String getProperty(String key, String defaultValue){
        return getProperty(key, String.class, defaultValue);
    }

    /**
     * 获取 Environment 中的值
     * @param key 键
     * @param clazz 值的类型
     * @param <T> 泛型
     * @return 环境变量中的值
     */
    public static <T> T getProperty(String key, Class<T> clazz){
        return getProperty(key, clazz, null);
    }

    /**
     * 获取 Environment 中的值
     * @param key 键
     * @param clazz 值的类型
     * @param <T> 泛型
     * @param defaultValue 为空时的默认值
     * @return 环境变量中的值
     */
    public static <T> T getProperty(String key, Class<T> clazz, T defaultValue){
        return getEnvironment().getProperty(key, clazz, defaultValue);
    }

    /**
     * 获取 单例对象
     * @param beanName 对象名称
     * @param <Bean> 对象类型
     * @return 对象
     */
    public static <Bean> Bean getBean(String beanName){
        return (Bean) applicationContext.getBean(beanName);
    }

    /**
     * 获取 单例对象
     * @param clazz 对象名称
     * @param <Bean> 对象类型
     * @return 对象
     */
    public static <Bean> Bean getBean(Class<Bean> clazz){
        return (Bean) applicationContext.getBean(clazz);
    }

    /**
     * 获取 单例对象
     * @param clazz 对象名称
     * @param <Bean> 对象类型
     * @return 对象
     */
    public static <Bean> Map<String, Bean> getBeanOfType(Class<Bean> clazz){
        return applicationContext.getBeansOfType(clazz);
    }

    /**
     * 获取文件:
     * <li>获取 resources 下文件: classpath:***.xml </li>
     * <li>获取 磁盘 下文件: file:C:\***.xml </li>
     * @param path 文件路径
     * @return 文件
     */
    public static File getFile(String filePath){
        try {
            return getResource(filePath).getFile();
        } catch (IOException e) {
            throw new MekatokException(e);
        }
    }

    /**
     * 获取资源:
     * <li>获取 resources 下文件: classpath:***.xml </li>
     * <li>获取 磁盘 下文件: file:C:\***.xml </li>
     * @param path 文件路径
     * @return 资源
     */
    public static Resource getResource(String resourcePath){
        Resource resource = applicationContext.getResource(resourcePath);
        if (!resource.exists()) throw new MekatokException();
        return resource;
    }

    /**
     * 获取 字典项的文本
     * @param code 编码
     * @return 字典的value
     */
    public static String getMessage(String code){
        return getMessage(code, null);
    }

    public static Environment getEnv(){
        return applicationContext.getEnvironment();
    }

    /**
     * 获取 字典项的文本
     * @param code 编码
     * @param args 占位符
     * @return 字典的value
     */
    public static String getMessage(String code, @Nullable Object[] args){
        return getMessage(code, args, null);
    }

    /**
     * 获取 字典项的文本
     * @param code 编码
     * @param args 占位符
     * @param defaultMessage 默认值
     * @param locale 本地
     * @return 字典的value
     */
    public static String getMessage(String code, @Nullable Object[] args, Locale locale){
        return applicationContext.getMessage(code, args, Global.DEFAULT_LOCAL);
    }

    /**
     * 获取 时间 的格式化模板
     * @return 字符串
     */
    public static String getTimeFormatStr(){
        return getProperty(JSON_FORMAT_DATATIME_MARK, "HH:mm:ss");
    }

    /**
     * 获取 日期 的格式化模板
     * @return 字符串
     */
    public static String getDateFormatStr(){
        return getProperty(JSON_FORMAT_DATA_MARK, "yyyy-MM-dd");
    }

    /**
     * 获取 日期时间 的格式化模板
     * @return 字符串
     */
    public static String getDateTimeFormatStr(){
        return getProperty(JSON_FORMAT_DATATIME_MARK, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取 时间 的格式化 对象
     * @return DateTimeFormatter
     */
    public static DateTimeFormatter getTimeFormat(){
        return DateTimeFormatter.ofPattern(getTimeFormatStr());
    }

    /**
     * 获取 日期 的格式化 对象
     * @return DateTimeFormatter
     */
    public static DateTimeFormatter getDateFormat(){
        return DateTimeFormatter.ofPattern(getDateFormatStr());
    }

    /**
     * 获取 日期时间 的格式化 对象
     * @return DateTimeFormatter
     */
    public static DateTimeFormatter getDateTimeFormat(){
        return DateTimeFormatter.ofPattern(getDateTimeFormatStr());
    }


}
