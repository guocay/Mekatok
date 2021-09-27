package icu.guokai.mekatok.framework.log.service;

import icu.guokai.mekatok.framework.core.service.IService;
import icu.guokai.mekatok.framework.netty.event.*;

/**
 * Netty相关日志打印器
 * @author GuoKai
 * @date 2021/9/10
 */
public interface INettyService extends IService {

    /**
     * 信道异常
     * @param event 事件
     */
    void channelException(ChannelException event);

    /**
     * 信道注册
     * @param event 事件
     */
    void channelRegistry(ChannelRegistry event);

    /**
     * 信道请求
     * @param event 事件
     */
    void channelRequest(ChannelRequest event);
}
