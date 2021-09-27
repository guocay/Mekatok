package icu.guokai.mekatok.framework.netty.event;

import icu.guokai.mekatok.framework.core.event.Event;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Tcp信道请求事件
 * @author GuoKai
 * @date 2021/9/10
 */
@Accessors
public class ChannelRequest extends Event<Object> {

    private static final long serialVersionUID = 3719358126086784331L;

    /**
     * 请求消息内容
     */
    private Object source;

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
    public ChannelRequest(Object source) {
        super(source);
    }

    @Override
    public String description() {
        return "Tcp信道请求";
    }

}
