package icu.guokai.mekatok.framework.netty.client.handler;

import icu.guokai.mekatok.framework.core.event.EventCenter;
import icu.guokai.mekatok.framework.netty.event.ChannelException;
import icu.guokai.mekatok.framework.netty.event.ChannelRegistry;
import icu.guokai.mekatok.framework.netty.event.ChannelRequest;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

/**
 * Tcp 消息代理
 * 用于处理 连接和请求
 * @author GuoKai
 * @date 2021/9/10
 */
@Component
@ChannelHandler.Sharable
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 有客户端连接时,调用.
     * @param ctx 信道
     * @throws Exception 异常
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        EventCenter.publish(new ChannelRegistry(ctx));
        super.channelActive(ctx);
    }

    /**
     * 读取 消费 信息
     * @param ctx 信道
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        EventCenter.publish(new ChannelRequest(msg).setContext(ctx));
    }

    /**
     * 在读取操作期间，有异常抛出时会调用。
     * 关闭TCP连接。
     * @param ctx 信道
     * @param cause 错误信息
     * @throws Exception 异常信息
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        EventCenter.publish(new ChannelException(cause).setContext(ctx));
        super.exceptionCaught(ctx, cause);
    }
}
