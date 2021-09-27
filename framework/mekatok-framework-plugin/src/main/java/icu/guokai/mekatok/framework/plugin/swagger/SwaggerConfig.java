package icu.guokai.mekatok.framework.plugin.swagger;

import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;

/**
 * Swagger的配置信息
 * @author GuoKai
 * @date 2021/8/13
 */
@Slf4j
@Configuration
@EnableSwagger2WebMvc
@SuppressWarnings("all")
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * 为Swagger增加首页转发.
     * @param registry 注册
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/doc.html");
    }

    @Bean
    public AsyncTask docketGroup(List<SwaggerDocket> list){
        return () -> {
            list.forEach(docket -> {
                log.info("Swagger: {} 分组已创建, 扫描路径为: {}", docket.title(), docket.basePackage());
            });
        };
    }

    /**
     * 默认的 Swagger 配置
     */
    @Component
    class DefaultSwaggerDocket extends SwaggerDocket{

        @Override
        public String title() {
            return "默认分组模块";
        }

        @Override
        public String description() {
            return "Mekatok是一个基于Spring Boot的敏捷开发框架.";
        }

        @Override
        public String authorName() {
            return Global.GK;
        }

        @Override
        public String version() {
            return Global.APPLICATION_VERSION;
        }

        @Override
        public String basePackage() {
            return Global.BASIC_PACKAGE_NAME;
        }

        @Override
        public String name() {
            return "default";
        }
    }
}
