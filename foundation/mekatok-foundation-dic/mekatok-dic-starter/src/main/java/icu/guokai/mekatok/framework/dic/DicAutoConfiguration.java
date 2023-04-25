package icu.guokai.mekatok.framework.dic;

import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.swagger.SwaggerDocket;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * dic模块自动化配置
 * @author GuoKai
 * @date 2021/8/16
 */
@Configuration
@SuppressWarnings("all")
@ComponentScan(DicModuleInfo.MODULE_ROOT_PATH)
public class DicAutoConfiguration {

    /**
     * 字典模块 的 Swagger 配置
     */
    @Component
    class DiskSwaggerDocket extends SwaggerDocket {

        @Override
        public String title() {
            return "字典管理模块";
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
        public String version() {
            return Global.APPLICATION_VERSION;
        }

        @Override
        public String basePackage() {
            return DicModuleInfo.MODULE_ROOT_PATH;
        }

        @Override
        public String name() {
            return DicModuleInfo.MODULE_NAME;
        }
    }
}
