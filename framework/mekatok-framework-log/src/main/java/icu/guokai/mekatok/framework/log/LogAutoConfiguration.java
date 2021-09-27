package icu.guokai.mekatok.framework.log;

import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.event.AsyncListener;
import icu.guokai.mekatok.framework.log.service.INettyService;
import icu.guokai.mekatok.framework.log.service.IRouterService;
import icu.guokai.mekatok.framework.netty.event.*;
import icu.guokai.mekatok.framework.plugin.async.EnableTask;
import icu.guokai.mekatok.framework.plugin.event.RouterCallAfter;
import icu.guokai.mekatok.framework.plugin.event.RouterCallBefore;
import icu.guokai.mekatok.framework.plugin.event.RouterCallMistake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 日志模块 自动配置
 * @author GuoKai
 * @date 2021/9/6
 */
@EnableTask
@Configuration
@SuppressWarnings("all")
@ComponentScan(Global.FRAMEWORK_PACKAGE_NAME + ".log")
public class LogAutoConfiguration {

    @Autowired
    private IRouterService router;

    @Autowired
    private INettyService netty;

    /**
     * 监听 Http请求到达Router前
     * @param event 事件
     */
    @AsyncListener
    public void routerCallAfter(RouterCallAfter event){
        router.routerCallAfter(event);
    }

    /**
     * 监听 Http请求Router完成后
     * @param event 事件
     */
    @AsyncListener
    public void routerCallBefore(RouterCallBefore event){
        router.routerCallBefore(event);
    }

    /**
     * 监听 Http请求Router异常后
     * @param event 事件
     */
    @AsyncListener
    public void routerCallMistake(RouterCallMistake event){
        router.routerCallMistake(event);
    }

    /**
     * 监听 Netty 信道异常
     * @param event 事件
     */
    @AsyncListener
    public void channelException(ChannelException event){
        netty.channelException(event);
    }

    /**
     * 监听 Netty 信道注册
     * @param event 事件
     */
    @AsyncListener
    public void channelRegistry(ChannelRegistry event){
        netty.channelRegistry(event);
    }

    /**
     * 监听 Netty 信道请求
     * @param event 事件
     */
    @AsyncListener
    public void channelRequest(ChannelRequest event){
        netty.channelRequest(event);
    }


}
