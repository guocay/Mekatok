package icu.guokai.mekatok.framework.ou;

import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.swagger.SwaggerDocket;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ou模块自动化配置
 * @author GuoKai
 * @date 2021/8/16
 */
@Configuration
@SuppressWarnings("all")
@ComponentScan(OuModuleInfo.MODULE_ROOT_PATH)
public class OuAutoConfiguration {

    /**
     * 组织用户模块 swagger 声明
     */
    @Component
    class OuSwaggerDocket extends SwaggerDocket{
        @Override
        public String title() {
            return "组织用户模块";
        }

        @Override
        public String description() {
            return title() + "相关接口";
        }

        @Override
        public String authorName() {
            return Global.GK;
        }

        @Override
        public String authorMail() {
            return "";
        }

        @Override
        public String version() {
            return Global.APPLICATION_VERSION;
        }

        @Override
        public String basePackage() {
            return OuModuleInfo.MODULE_ROOT_PATH;
        }

        @Override
        public String name() {
            return OuModuleInfo.MODULE_NAME;
        }
    }
}


