package com.github.guokaia.mekatok.auth.service;

import com.github.guokaia.mekatok.context.MekatokApplication;
import com.github.guokaia.mekatok.message.redis.EnableRedisMessageQueue;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 认证相关服务
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/5
 */
@SpringCloudApplication
@EnableRedisMessageQueue
public class AuthApplication {
    public static void main(String[] args) {
        MekatokApplication.run(AuthApplication.class, args);
    }
}
