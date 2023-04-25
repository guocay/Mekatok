package icu.guokai.mekatok.framework.netty.event;

import icu.guokai.mekatok.framework.core.event.Event;
import io.netty.channel.ChannelHandlerContext;
import lombok.experimental.Accessors;

/**
 * Tcp 通道连接事件
 * @author GuoKai
 * @date 2021/9/10
 */
@Accessors
public class ChannelRegistry extends Event<ChannelHandlerContext> {

    private static final long serialVersionUID = 2814221268047536390L;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ChannelRegistry(ChannelHandlerContext source) {
        super(source);
    }

    @Override
    public String description() {
        return "Tcp信道注册";
    }

}
