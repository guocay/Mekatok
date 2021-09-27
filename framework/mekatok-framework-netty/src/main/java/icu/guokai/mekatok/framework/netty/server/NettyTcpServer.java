package icu.guokai.mekatok.framework.netty.server;

import icu.guokai.mekatok.framework.netty.property.Property;
import icu.guokai.mekatok.framework.netty.server.handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

/**
 * 用于启动 tcp server 的服务插件
 * @author GuoKai
 * @date 2021/9/10
 */
@Slf4j
@Component
@SuppressWarnings("all")
public class NettyTcpServer {

    private final EventLoopGroup boss = new NioEventLoopGroup();

    private final EventLoopGroup worker = new NioEventLoopGroup();

    private ChannelFuture future;

    @Autowired
    private NettyServerHandler handler;

    @Autowired
    private Property property;

    @PostConstruct
    public void start(){
        var port = property.getPort();
        future = new ServerBootstrap().group(boss,worker).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                        socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                        // todo 为监听客户端read/write事件的Channel添加用户自定义的ChannelHandler
                        socketChannel.pipeline().addLast(handler);
                    }
                }).bind(port).syncUninterruptibly();
        log.info("Netty Server启动成功,监听端口为: {}", port);
    }

    @PreDestroy
    public void destroy(){
        boss.shutdownGracefully();
        worker.shutdownGracefully();
        Optional.ofNullable(future).ifPresent(future -> future.channel().close());
        log.info("Netty Server关闭成功, Bye!!!");
    }
}
