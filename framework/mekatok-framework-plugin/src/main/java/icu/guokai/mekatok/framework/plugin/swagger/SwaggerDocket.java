package icu.guokai.mekatok.framework.plugin.swagger;

import cn.hutool.extra.spring.SpringUtil;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 用于设置Swagger分组信息
 * @author GuoKai
 * @date 2021/8/31
 */
@Slf4j
public abstract class SwaggerDocket extends Docket {

    public SwaggerDocket() {
        // 初始化
        super(DocumentationType.SWAGGER_2);
        // api相关信息
        var apiInfo = new ApiInfoBuilder().title(title()).description(description())
                .contact(new Contact(authorName(),authorUrl(),authorMail()))
                .version(version()).build();
        // 设置当前对象
        this.directModelSubstitute(LocalDateTime.class,String.class)
                .directModelSubstitute(LocalTime.class,String.class)
                .directModelSubstitute(LocalDate.class,String.class)
                .enable(true).apiInfo(apiInfo).groupName(name()).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage()))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()).build()
                .extensions(SpringUtil.getBean(OpenApiExtensionResolver.class).buildExtensions(name()));
    }

    /**
     * 标题
     * @return 标题
     */
    public abstract String title();

    /**
     * 备注
     * @return 备注
     */
    public abstract String description();

    /**
     * 创作者名称
     * @return 创作者名称
     */
    public abstract String authorName();

    /**
     * 创作者地址
     * @return 创作者地址
     */
    public String authorUrl(){
        return "";
    }

    /**
     * 创作者邮箱
     * @return 创作者邮箱
     */
    public String authorMail() {
        return "guokaia@mail.taiji.com.cn";
    }

    /**
     * 版本
     * @return 版本
     */
    public abstract String version();

    /**
     * 扫描路径
     * @return 扫描路径
     */
    public abstract String basePackage();

    /**
     * 分组名称
     * @return 分组名称
     */
    public abstract String name();

}
