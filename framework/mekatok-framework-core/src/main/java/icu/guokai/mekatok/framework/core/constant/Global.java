package icu.guokai.mekatok.framework.core.constant;


import cn.hutool.extra.spring.SpringUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 全局变量配置
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("all")
public class Global {

    /**
     * 平台相关常量
     */
    public static final String BASIC_PACKAGE_NAME = "icu.guokai.mekatok";
    public static final String MODULE_PACKAGE_NAME = BASIC_PACKAGE_NAME + ".module";
    public static final String FRAMEWORK_PACKAGE_NAME = BASIC_PACKAGE_NAME + ".framework";
    public static final String BASIC_SERVICE_PATH = "/api";
    public static final String DEFAULT_FILE_PATH = "DEFAULT_FILE_PATH";
    public static final String DEFAULT_TRASH_PATH = "DEFAULT_TRASH_PATH";
    public static final Integer HTTP_PORT = getProperty("info.application.http-port",Integer.class,727);
    public static final Integer HTTPS_PORT = getProperty("info.application.https-port",Integer.class,508);
    public static final String RESOURCE_FILE_PATH = getProperty("info.application.resource",String.class, "resource") + File.separator;
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final String DEFAULT_CHARSET_NAME = DEFAULT_CHARSET.name();

    /**
     * JWT 相关配置
     */
    public static final String JWT_PRIVATE_KEY = BASIC_PACKAGE_NAME + ".jwt.private.key";
    public static final String JWT_TOKEN = "M-TOKEN";
    public static final Integer JWT_TTL = getProperty("info.application.security.ttl",Integer.class,30*60*1000);

    /**
     * Coder
     */
    public static final String GK = "GuoKai";

    /**
     * 应用相关信息
     */
    public static final String APPLICATION_NAME = getProperty("info.application.name",String.class,"DEMO项目");
    public static final String APPLICATION_VERSION = getProperty("info.application.version",String.class,"0.0.1");

    /**
     * 异常与错误流程相关配置
     */
    public static final String MISTAKE_CODE_DEFAULT = "M-CORE-0000";

    /**
     * SpringUtil工具类目录,用于指示@EnablePlatformScan去扫描并注册类
     */
    public static final String SPRING_UTIL_BEAN_NAME = "springUtil";

    /**
     * 分页相关配置
     */
    public static final String PAGE_CURRENT_MARK = "M-PAGE-CURRENT";
    public static final String PAGE_SIZE_MARK = "M-PAGE-SIZE";
    public static final String IS_PAGINATION_MARK = "M-PAGE-PAGINATION";
    public static final String DATA_TOTAL_MARK = "M-DATA-TOTAL";
    public static final String DATA_SIZE_MARK = "M-DATA-SIZE";
    public static final String DATA_CURRENT_MARK = "M-DATA-CURRENT";
    public static final Long DEFAULT_PAGE_SIZE = getProperty("info.application.default-page-size",Long.class,10L);

    /**
     * 数据有效性
     */
    public static final String EFFECTIVE_STATUS = getProperty("mybatis-plus.global-config.db-config.logic-not-delete-value",String.class);
    public static final String INVALID_STATUS = getProperty("mybatis-plus.global-config.db-config.logic-delete-value",String.class);

    /**
     * (雪花算法)
     * 数据中心与工作机配置
     */
    public static final long DATA_CENTER_ID = getProperty("info.application.data-center-id",Long.class,0L);
    public static final long WORKER_ID = getProperty("info.application.worker-id",Long.class,0L);


    /**
     * 日期格式化
     */
    public static final String TIME_FORMAT = getProperty("info.application.time-format",String.class);
    public static final String DATE_FORMAT = getProperty("info.application.date-format",String.class);
    public static final String DATETIME_FORMAT = getProperty("info.application.datetime-format",String.class);

    /**
     * 异常相关配置
     */
    public static final String MISTAKE_ROUTE_PATH = getProperty("server.error.path",String.class,"/mistake");

    /**
     * 密码加密器
     */
    public static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    /**
     * 用户缓存Key
     */
    public static final String SECURITY_USER_CACHE = "SECURITY_USER_CACHE";

    /**
     * 缓存相关配置
     */
    public static final String CACHE_KEY_GENERATOR = "cacheKeyGenerator";

    /**
     * websocket 相关配置
     */

    public static final String MESSAGE_PATH = "/websocket";
    public static final String STOMP_PATH = "/stomp";
    public static final String STOMP_CHAT_CHANNEL = "/chat";

    /**
     * 任务调度相关配置
     */
    public static final String TASK_EXECUTOR_PREFIX = "mekatok-platform-thread-pool-";

    /**
     * 获取application中的值
     */
    public static <T> T getProperty(String key, Class<T> clazz){
        return getProperty(key,clazz,null);
    }

    /**
     * 获取application中的值
     */
    public static <T> T getProperty(String key, Class<T> clazz, T defaultValue){
        return SpringUtil.getApplicationContext().getEnvironment().getProperty(key, clazz, defaultValue);
    }

}
