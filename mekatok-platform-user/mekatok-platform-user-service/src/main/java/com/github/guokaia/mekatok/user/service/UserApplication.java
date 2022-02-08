package com.github.guokaia.mekatok.user.service;

import com.github.guokaia.mekatok.context.MekatokApplication;
import com.github.guokaia.mekatok.message.redis.EnableRedisMessageQueue;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 用户服务
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
@SpringCloudApplication
@EnableRedisMessageQueue
public class UserApplication {
    public static void main(String[] args) {
        MekatokApplication.run(UserApplication.class, args);
    }
}
