package icu.guokai.mekatok.framework.security.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全相关环境配置
 * @author GuoKai
 * @date 2021/8/18
 */
@Data
@ConfigurationProperties("info.application.security")
public class Property {

    /**
     * 是否开启路由保护
     */
    private Boolean enable;

    /**
     * 需要保护的路由
     */
    private String[] permit;

    /**
     * 缓存过期时间
     * 登录有效期
     */
    private Long ttl;

    /**
     * 认证类型
     */
    private String grantType;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 客户端证书
     */
    private String clientSecret;

    /**
     * 转发地址
     */
    private String redirectUri;
}
