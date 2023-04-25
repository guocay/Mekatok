package icu.guokai.mekatok.framework.netty.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Netty服务器相关配置
 * @author GuoKai
 * @date 2021/9/10
 */
@Data
@ConfigurationProperties("info.application.netty")
public class Property {

    /**
     * 端口
     */
    private Integer port;
}
