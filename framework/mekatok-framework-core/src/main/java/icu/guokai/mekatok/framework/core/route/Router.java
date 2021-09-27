package icu.guokai.mekatok.framework.core.route;

import icu.guokai.mekatok.framework.core.message.support.WebMvcMessageSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 平台 路由(Contorller) 的基类
 * @author GuoKai
 * @date 2021/8/5
 */
public abstract class Router implements WebMvcMessageSupport {

    /**
     * 日志对象,用于打印消息
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

}
