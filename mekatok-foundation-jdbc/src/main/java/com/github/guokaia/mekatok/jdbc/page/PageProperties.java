package com.github.guokaia.mekatok.jdbc.page;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 分页的配置项
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
@Data
@ConfigurationProperties(prefix = "mekatok.jdbc.page")
public class PageProperties {
    /**
     * 分页的大小
     */
    private Long size = 10L;
}
