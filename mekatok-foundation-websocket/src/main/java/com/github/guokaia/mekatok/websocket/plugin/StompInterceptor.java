package com.github.guokaia.mekatok.websocket.plugin;

import lombok.NoArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * 客户端信道拦截适配器
 * @author GuoKai
 * @date 2021/8/24
 */
@SuppressWarnings("all")
@NoArgsConstructor(staticName = "of")
public class StompInterceptor implements ChannelInterceptor {

    /**
     * 消息发送前调用<br/>
     * {@code StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);}<br/>
     * 设置accessor.setUser(Principal), 就可以在后续验证权限了.<br/>
     * 可以通过 accessor.getCommand(), 获取当前请求是什么类型, 详见 {@link org.springframework.messaging.simp.stomp.StompCommand}
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        return message;
    }

    /**
     * 消息发送后调用
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
