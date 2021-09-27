package icu.guokai.mekatok.framework.plugin.verify.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 服务校验 相关属性
 * @author GuoKai
 * @date 2021/8/13
 */
@Data
@ConfigurationProperties("info.application.cs-verify")
public class Property {

    /**
     * 是否开启序列号校验
     */
    private Boolean enable;

    /**
     * 允许启动的服务器序列号
     */
    private String[] serverSerial;

    /**
     * 客户端白名单
     */
    private String[] clientIp;
}
