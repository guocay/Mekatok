package icu.guokai.mekatok.framework.netty.server;

import icu.guokai.mekatok.framework.netty.property.Property;
import icu.guokai.mekatok.framework.netty.server.handler.NettyServerHandler;
import icu.guokai.mekatok.framework.plugin.spring.EnableSpring;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启Netty服务器
 * @author GuoKai
 * @date 2021/9/10
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableSpring
@EnableConfigurationProperties(Property.class)
@Import({NettyServerHandler.class,NettyTcpServer.class})
public @interface EnableNetty {
}
