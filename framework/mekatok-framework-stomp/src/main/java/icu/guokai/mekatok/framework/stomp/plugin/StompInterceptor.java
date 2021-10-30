package icu.guokai.mekatok.framework.stomp.plugin;

import icu.guokai.mekatok.framework.core.constant.Global;
import lombok.NoArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * 客户端信道拦截适配器
 * @author GuoKai
 * @date 2021/8/24
 */
@SuppressWarnings("all")
@NoArgsConstructor(staticName = "of")
public class StompInterceptor implements ChannelInterceptor {

    /**
     * 消息发送前调用
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        var accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        switch (accessor.getCommand()){
            // 断开连接
            case DISCONNECT:
                break;
            // 订阅通道
            case SUBSCRIBE:
                break;
            // 关闭订阅
            case UNSUBSCRIBE:
                break;
            default:
                // 绑定 客户端信息至 accessor
                // 报错则拒绝连接... 兼顾了安全校验
                accessor.setUser(SimplePrincipal.of(accessor.getNativeHeader(Global.JWT_TOKEN).get(0)));
                break;
        }
        return message;
    }

    /**
     * 消息发送后调用
     * @param message
     * @param channel
     * @param sent
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

    }

    /**
     * 消息发送完成后调用
     * @param message
     * @param channel
     * @param sent
     * @param ex
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {

    }

    /**
     * 消息被实际检索之前调用
     * @param channel
     * @return
     */
    @Override
    public boolean preReceive(MessageChannel channel) {
        return true;
    }

    /**
     * 消息被实际检索之后调用
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return message;
    }

    /**
     * 消息接收完成之后调用
     * @param message
     * @param channel
     * @param ex
     */
    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {

    }
}
