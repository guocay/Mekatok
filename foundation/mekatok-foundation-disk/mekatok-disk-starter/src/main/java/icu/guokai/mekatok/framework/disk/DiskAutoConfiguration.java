package icu.guokai.mekatok.framework.disk;

import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.swagger.SwaggerDocket;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 文件管理模块自动化配置
 * @author GuoKai
 * @date 2021/8/20
 */
@Configuration
@ComponentScan(DiskModuleInfo.MODULE_ROOT_PATH)
public class DiskAutoConfiguration {

    /**
     * Disk模块 的 Swagger 配置
     */
    @Component
    class DiskSwaggerDocket extends SwaggerDocket{

        @Override
        public String title() {
            return "文件管理模块";
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
            return DiskModuleInfo.MODULE_ROOT_PATH;
        }

        @Override
        public String name() {
            return DiskModuleInfo.MODULE_NAME;
        }
    }
}
