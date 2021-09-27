package icu.guokai.mekatok.framework.disk;

import icu.guokai.mekatok.framework.core.constant.Global;

/**
 * 用于定义模块中的一些基础数据,作为Global对象的延伸
 * @author GuoKai
 * @date 2021/8/20
 */
public class DiskModuleInfo {

    /**
     * 模块名称
     */
    public static final String MODULE_NAME = "disk";

    /**
     * 模块路由前缀
     */
    public static final String MODULE_ROUTE_URI = Global.BASIC_SERVICE_PATH + "/" + MODULE_NAME;

    /**
     * 代码包的根路径
     */
    public static final String MODULE_ROOT_PATH = Global.FRAMEWORK_PACKAGE_NAME + "." + MODULE_NAME;
}
