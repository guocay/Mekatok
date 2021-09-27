package icu.guokai.mekatok.framework.netty.client;

import icu.guokai.mekatok.framework.netty.client.handler.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用于链接Netty服务器的客户端
 * @author GuoKai
 * @date 2021/9/10
 */
@Accessors
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NettyClient {

    /**
     * 通道
     */
    private ChannelFuture future;

    /**
     * 链接服务器
     * @param host 主机
     * @param port 端口
     * @return 成功与否
     */
    public static NettyClient connect(String host, Integer port){
        var bs = new Bootstrap().group(new NioEventLoopGroup()).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                // todo 为监听客户端read/write事件的Channel添加用户自定义的ChannelHandler
                socketChannel.pipeline().addLast(new NettyClientHandler());
            }
        });
        var client = new NettyClient();
        client.future = bs.connect(host, port).syncUninterruptibly();
        return client;
    }

    /**
     * 发送消息
     * @param msg 消息内容
     * @return 是否成功
     */
    public Boolean send(String msg){
        future.channel().writeAndFlush(Unpooled.copiedBuffer(msg.getBytes(CharsetUtil.UTF_8)));
        return true;
    }

}
