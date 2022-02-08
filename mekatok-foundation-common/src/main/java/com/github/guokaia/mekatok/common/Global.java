package com.github.guokaia.mekatok.common;

import com.github.guokaia.mekatok.common.bcrypt.BCryptEncoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 全局常量配置
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
public class Global {

    private Global(){}

    /**
     * 平台相关常量
     */
    public static final String BASIC_SERVICE_PATH = "/api";
    public static final String DEFAULT_FILE_PATH = "DEFAULT_FILE_PATH";
    public static final String DEFAULT_TRASH_PATH = "DEFAULT_TRASH_PATH";
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final String DEFAULT_CHARSET_NAME = DEFAULT_CHARSET.name();
    public static final String SPRING_MESSAGE_BASE_NAME = "message/dictionary";
    public static final Locale DEFAULT_LOCAL = Locale.CHINA;
    public static final String AUTHENTICATION_MARK = "M-AUTHENTICATION";

    /**
     * 密码加密器
     */
    public static final String DEFAULT_USER_PASSWORD = "123456";
    public static final BCryptEncoder ENCODER = new BCryptEncoder();

    /**
     * 平台内用户登录缓存实现
     */
    public static final String USER_LOGIN_STATUS_CACHE_NAME = "MEKATOK_USER_LOGIN_STATUS_CACHE_NAME";

    /**
     * JWT 相关配置
     * JWT_PRIVATE_KEY 的长度不得小于 byte[32]. 256-bit
     */
    public static final String JWT_PRIVATE_KEY = "com.github.guokaia.mekatok.jwt.private.key";
    public static final String JWT_TOKEN = "M-TOKEN";

    /**
     * 分页相关配置
     */
    public static final String PAGE_CURRENT_MARK = "M-PAGE-CURRENT";
    public static final String PAGE_SIZE_MARK = "M-PAGE-SIZE";
    public static final String IS_PAGINATION_MARK = "M-PAGE-PAGINATION";
    public static final String DATA_TOTAL_MARK = "M-DATA-TOTAL";
    public static final String DATA_SIZE_MARK = "M-DATA-SIZE";
    public static final String DATA_CURRENT_MARK = "M-DATA-CURRENT";

    /**
     * 线程池相关配置
     */
    public static final String THREAD_POOL_NAME_PREFIX = "mekatok-platform-thread-pool-";
    public static final String THREAD_POOL_BEAN_NAME = "mekatokThreadPoolBean";

    /**
     * websocket 相关配置
     */
    public static final String WEBSOCKET_MESSAGE_PATH = "/websocket";
    public static final String WEBSOCKET_STOMP_PATH = "/stomp";
    public static final String WEBSOCKET_STOMP_CHAT_CHANNEL = "/chat";
}
