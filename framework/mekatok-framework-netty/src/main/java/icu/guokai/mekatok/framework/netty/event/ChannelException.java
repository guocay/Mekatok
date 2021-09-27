package icu.guokai.mekatok.framework.netty.event;

import icu.guokai.mekatok.framework.core.event.Event;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Tcp Server 信道 异常 事件
 * @author GuoKai
 * @date 2021/9/10
 */
@Accessors
public class ChannelException extends Event<Throwable> {

    private static final long serialVersionUID = -1791691289828802380L;

    /**
     * ChannelHandlerContext 对象
     * @see io.netty.channel.ChannelHandlerContext
     */
    @Getter
    @Setter
    private ChannelHandlerContext context;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ChannelException(Throwable source) {
        super(source);
    }


    @Override
    public String description() {
        return "Tcp信道异常";
    }

}
