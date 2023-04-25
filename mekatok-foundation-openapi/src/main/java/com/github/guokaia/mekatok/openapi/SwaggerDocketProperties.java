package com.github.guokaia.mekatok.openapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 定义的分组信息
 * @author GuoKai
 * @date 2022/2/1
 */
@Data
@ConfigurationProperties(prefix = "mekatok.swagger")
public class SwaggerDocketProperties {

    /**
     * 默认标题
     */
    private String title = "Mekatok";

    /**
     * 扫描路径
     */
    private String basePackage = "";

    /**
     * 版本
     */
    private String version = "";

    /**
     * 负责人
     */
    private String author = "";

    /**
     * 分组描述
     */
    private String description = "";
}
