package icu.guokai.mekatok.framework.log.impl;

import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import icu.guokai.mekatok.framework.log.service.INettyService;
import icu.guokai.mekatok.framework.netty.event.*;
import org.springframework.stereotype.Service;

/**
 * Netty日志服务实现类
 * @author GuoKai
 * @date 2021/9/10
 */
@Service
public class NettyServiceImpl extends ServiceImpl implements INettyService {
    @Override
    public void channelException(ChannelException event) {
        var th = event.getMeta();
        log.error(th.getMessage(),th);
    }

    @Override
    public void channelRegistry(ChannelRegistry event) {
        var ctx = event.getMeta();
        log.info("客户端 {} 已连接 Netty服务器.",ctx.channel().remoteAddress().toString());
    }

    @Override
    public void channelRequest(ChannelRequest event) {
        var msg = event.getMeta();
        var ctx = event.getContext();
        log.info("客户端 {} 发送请求: {}", ctx.channel().remoteAddress().toString().substring(1), msg.toString());
    }
}
