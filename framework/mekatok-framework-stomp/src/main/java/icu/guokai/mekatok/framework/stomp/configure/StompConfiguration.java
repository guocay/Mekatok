package icu.guokai.mekatok.framework.stomp.configure;

import com.fasterxml.jackson.databind.ObjectMapper;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.swagger.SwaggerDocket;
import icu.guokai.mekatok.framework.stomp.plugin.StompInterceptor;
import icu.guokai.mekatok.framework.stomp.plugin.WebSocketInterceptor;
import icu.guokai.mekatok.framework.stomp.route.ChatRoomRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;
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
 * @date 2021/8/24
 */
@Configuration
@SuppressWarnings("all")
@Import(ChatRoomRouter.class)
@EnableWebSocketMessageBroker
public class StompConfiguration implements WebSocketMessageBrokerConfigurer {

    @Autowired(required = false)
    private ObjectMapper mapper;

    /**
     * 单元名称
     */
    public static final String UNIT_NAME = "stomp";

    /**
     * 添加这个Endpoint，这样在网页中就可以通过websocket连接上服务,也就是我们配置websocket的服务地址,并且可以指定是否使用socketjs
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(Global.STOMP_PATH).addInterceptors(webSocketInterceptor())
                .setAllowedOriginPatterns("*");
    }

    /**
     * 配置发送与接收的消息参数，可以指定消息字节大小，缓存大小，发送超时时间
     * @param registry 注册对象
     */
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        /*
         * 1. setMessageSizeLimit 设置消息缓存的字节数大小 字节
         * 2. setSendBufferSizeLimit 设置websocket会话时，缓存的大小 字节
         * 3. setSendTimeLimit 设置消息发送会话超时时间，毫秒
         */
        registry.setMessageSizeLimit(10 * 1024).setSendBufferSizeLimit(10 * 1024).setSendTimeLimit(10 * 1000);
    }

    /**
     * 设置输入消息通道的线程数，默认线程为1，可以自己自定义线程数，最大线程数，线程存活时间
     * @param registration
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        /*
         * 配置消息线程池
         * 1. corePoolSize 配置核心线程池，当线程数小于此配置时，不管线程中有无空闲的线程，都会产生新线程处理任务
         * 2. maxPoolSize 配置线程池最大数，当线程池数等于此配置时，不会产生新线程
         * 3. keepAliveSeconds 线程池维护线程所允许的空闲时间，单位秒
         */
        registration.taskExecutor().corePoolSize(10)
                .maxPoolSize(20).keepAliveSeconds(60);
        /*
         * 添加stomp自定义拦截器，可以根据业务做一些处理
         * springframework 4.3.12 之后版本此方法废弃，代替方法 interceptors(ChannelInterceptor... interceptors)
         * 消息拦截器，实现ChannelInterceptor接口
         */
        registration.setInterceptors(stompChannelInterceptor());
    }

    /**
     * 设置输出消息通道的线程数，默认线程为1，可以自己自定义线程数，最大线程数，线程存活时间
     * @param registra j'j'j'j'jtion
     */
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.taskExecutor().corePoolSize(10)
                .maxPoolSize(20).keepAliveSeconds(60);
    }

    /**
     * 自定义控制器方法的参数类型，有兴趣可以百度google HandlerMethodArgumentResolver这个的用法
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    /**
     * 自定义控制器方法的参数类型，有兴趣可以百度google HandlerMethodArgumentResolver这个的用法
     * @param returnValueHandlers
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    /**
     * 添加自定义的消息转换器，spring 提供多种默认的消息转换器，返回false,不会添加消息转换器，
     * 返回true，会添加默认的消息转换器，当然也可以把自己写的消息转换器添加到转换链中
     * @param messageConverters
     * @return
     */
    @Override
    public boolean configureMessageConverters(List<MessageConverter> converters) {
        var converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(mapper);
        converters.add(converter);
        return true;
    }

    /**
     * 配置消息代理，哪种路径的消息会进行代理处理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(Global.MESSAGE_PATH);

        /*
         * 自定义路径分割符
         * PS: 没别的意思, 就是炫耀下知识体系.
         * ^_^ ^_^ ^_^
         */
        registry.setPathMatcher(new AntPathMatcher("/"));
    }

    /**
     * Stomp模块 swagger 分组定义
     */
    @Component
    class StompSwaggerDocket extends SwaggerDocket{

        @Override
        public String title() {
            return "Stomp模块";
        }

        @Override
        public String description() {
            return title() + "相关接口";
        }

        @Override
        public String authorName() {
            return Global.GK;
        }

        @Override
        public String version() {
            return Global.APPLICATION_VERSION;
        }

        @Override
        public String basePackage() {
            return String.format("%s.%s",Global.FRAMEWORK_PACKAGE_NAME,UNIT_NAME);
        }

        @Override
        public String name() {
            return UNIT_NAME;
        }
    }


    //--------------------------------------------暴露 bean-------------------------------------------------------

    @Bean
    public ChannelInterceptor stompChannelInterceptor(){
        return StompInterceptor.of();
    }

    @Bean
    public HandshakeInterceptor webSocketInterceptor(){
        return WebSocketInterceptor.of();
    }
}
