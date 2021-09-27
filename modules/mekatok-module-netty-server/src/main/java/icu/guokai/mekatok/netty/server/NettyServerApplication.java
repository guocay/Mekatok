package icu.guokai.mekatok.netty.server;

import icu.guokai.mekatok.framework.netty.server.EnableNetty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Netty 服务器
 * @author GuoKai
 * @date 2021/9/10
 */
@EnableNetty
@SpringBootApplication
public class NettyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class,args);
    }
}
