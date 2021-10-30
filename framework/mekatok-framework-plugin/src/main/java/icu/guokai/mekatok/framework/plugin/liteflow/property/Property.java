package icu.guokai.mekatok.framework.plugin.liteflow.property;

import cn.hutool.core.util.ArrayUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 服务校验 相关属性
 * @author GuoKai
 * @date 2021/8/13
 */
@Data
@ConfigurationProperties("info.application.liteflow")
public class Property {
    /**
     * 客户端白名单
     */
    private String[] ruleSources;

    public String getRuleSources() {
        return ArrayUtil.join(ruleSources,",");
    }
}
