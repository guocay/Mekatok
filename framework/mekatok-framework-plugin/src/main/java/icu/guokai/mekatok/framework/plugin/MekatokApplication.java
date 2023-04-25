package icu.guokai.mekatok.framework.plugin;

import icu.guokai.mekatok.framework.plugin.advice.EnableWebMvc;
import icu.guokai.mekatok.framework.plugin.async.EnableTask;
import icu.guokai.mekatok.framework.plugin.jdbc.EnableMyBatisPlus;
import icu.guokai.mekatok.framework.plugin.liteflow.EnableLiteFlow;
import icu.guokai.mekatok.framework.plugin.router.EnableRouterPlus;
import icu.guokai.mekatok.framework.plugin.spring.EnableSpring;
import icu.guokai.mekatok.framework.plugin.swagger.EnableSwagger;
import icu.guokai.mekatok.framework.plugin.verify.EnableHostVerify;
import icu.guokai.mekatok.framework.plugin.web.EnableServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.*;

/**
 * 默认开启的插件和配置
 * 添加此注解后,无需添加@SpringBootApplication注解
 * @author GuoKai
 * @date 2021/8/19
 */
@SpringBootApplication
@EnableTask
@EnableRouterPlus
@EnableHostVerify
@EnableMyBatisPlus
@EnableWebMvc
@EnableSpring
@EnableServer
@EnableSwagger
@EnableLiteFlow
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MekatokApplication {
}
