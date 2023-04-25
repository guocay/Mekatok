package com.github.guokaia.mekatok.openapi;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger 分组的自动配置类
 * @author GuoKai
 * @date 2022/2/1
 */
@EnableSwagger2WebMvc
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({SwaggerDocketProperties.class})
public class SwaggerAutoConfiguration {

    private final SwaggerDocketProperties properties;

    public SwaggerAutoConfiguration(SwaggerDocketProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Docket openApiInfo(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
            .select().apis(RequestHandlerSelectors.basePackage(properties.getBasePackage())).build();
    }

    /**
     * 设置 api 的信息
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().contact(new Contact(properties.getAuthor(), "", ""))
            .termsOfServiceUrl("http://guokai.me:11202")
            .title(properties.getTitle()).description(properties.getDescription())
            .version(properties.getVersion()).build();
    }

}
