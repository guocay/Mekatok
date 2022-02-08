package com.github.guokaia.mekatok.oss.service;

import com.github.guokaia.mekatok.context.MekatokApplication;
import com.github.guokaia.mekatok.message.redis.EnableRedisMessageQueue;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 对象存储服务启动类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/5
 */
@SpringCloudApplication
@EnableRedisMessageQueue
public class OssApplication {
    public static void main(String[] args) {
        MekatokApplication.run(OssApplication.class, args);
    }
}
