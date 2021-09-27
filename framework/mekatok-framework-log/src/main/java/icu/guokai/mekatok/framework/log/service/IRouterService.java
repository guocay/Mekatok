package icu.guokai.mekatok.framework.log.service;

import icu.guokai.mekatok.framework.core.service.IService;
import icu.guokai.mekatok.framework.plugin.event.RouterCallAfter;
import icu.guokai.mekatok.framework.plugin.event.RouterCallBefore;
import icu.guokai.mekatok.framework.plugin.event.RouterCallMistake;

/**
 * 路由相关日志打印器
 * @author GuoKai
 * @date 2021/9/6
 */
public interface IRouterService extends IService {

    /**
     * 用于处理 RouterCallAfter 事件
     * @param event 事件
     */
    void routerCallAfter(RouterCallAfter event);

    /**
     * 用于处理 RouterCallBefore 事件
     * @param event 事件
     */
    void routerCallBefore(RouterCallBefore event);

    /**
     * 用于处理 RouterCallMistake 事件
     * @param event 事件
     */
    void routerCallMistake(RouterCallMistake event);
}
