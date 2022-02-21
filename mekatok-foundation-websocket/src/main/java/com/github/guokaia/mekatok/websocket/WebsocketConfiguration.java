package com.github.guokaia.mekatok.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.context.json.JsonAutoConfiguration;
import com.github.guokaia.mekatok.context.thread.ThreadPoolAutoConfiguration;
import com.github.guokaia.mekatok.websocket.plugin.StompInterceptor;
import com.github.guokaia.mekatok.websocket.plugin.WebSocketInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.List;

/**
 * 配置stomp服务器
 * @author GuoKai
 * @date 2022/2/5
 */
@SuppressWarnings("all")
@EnableWebSocketMessageBroker
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter({ThreadPoolAutoConfiguration.class, JsonAutoConfiguration.class})
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private final ThreadPoolTaskExecutor executor;

    private final ObjectMapper mapper;

    public WebsocketConfiguration(ThreadPoolTaskExecutor executor, ObjectMapper mapper) {
        this.executor = executor;
        this.mapper = mapper;
    }

    /**
     * 添加这个Endpoint，这样在网页中就可以通过websocket连接上服务,也就是我们配置websocket的服务地址,并且可以指定是否使用socketjs
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(Global.WEBSOCKET_STOMP_PATH)
            .addInterceptors(webSocketInterceptor())
            .setAllowedOrigins("*");
    }

    /**
     * 配置发送与接收的消息参数，可以指定消息字节大小，缓存大小，发送超时时间
     * @param registry 注册对象
     */
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        /*
            1. setMessageSizeLimit 设置消息缓存的字节数大小 字节
            2. setSendBufferSizeLimit 设置websocket会话时，缓存的大小 字节
            3. setSendTimeLimit 设置消息发送会话超时时间，毫秒
         */
        registry.setMessageSizeLimit(10 * 1024)
            .setSendBufferSizeLimit(10 * 1024)
            .setSendTimeLimit(10 * 1000);
    }

    /**
     * 设置客户端入站通道
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        // 配置消息线程池
        registration.taskExecutor(executor);
        /*
            添加stomp自定义拦截器，可以根据业务做一些处理
            消息拦截器，实现ChannelInterceptor接口
         */
        registration.interceptors(stompChannelInterceptor());
    }

    /**
     * 设置客户端出站通道
     */
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        // 配置消息线程池
        registration.taskExecutor(executor);
    }

    /**
     * 添加自定义的消息转换器，spring 提供多种默认的消息转换器，返回false,不会添加消息转换器，
     * 返回true，会添加默认的消息转换器，当然也可以把自己写的消息转换器添加到转换链中
     */
    @Override
    public boolean configureMessageConverters(List<MessageConverter> converters) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(mapper);
        converters.add(converter);
        return true;
    }

    /**
     * 配置消息代理，哪种路径的消息会进行代理处理
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(Global.WEBSOCKET_MESSAGE_PATH);

        /*
         * 自定义路径分割符
         * PS: 没别的意思, 就是炫耀下知识体系.
         * ^_^ ^_^ ^_^
         */
        registry.setPathMatcher(new AntPathMatcher("/"));
    }

    @Bean
    public ChannelInterceptor stompChannelInterceptor(){
        return StompInterceptor.of();
    }

    @Bean
    public HandshakeInterceptor webSocketInterceptor(){
        return WebSocketInterceptor.of();
    }

}
