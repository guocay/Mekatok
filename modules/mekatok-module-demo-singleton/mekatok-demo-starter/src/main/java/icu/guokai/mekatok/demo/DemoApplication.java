package icu.guokai.mekatok.demo;

import icu.guokai.mekatok.framework.cache.redis.EnableRedisCache;
import icu.guokai.mekatok.framework.flowable.configure.EnableCustomFlowable;
import icu.guokai.mekatok.framework.plugin.MekatokApplication;
import icu.guokai.mekatok.framework.security.configure.simple.EnableSimpleSecurity;
import icu.guokai.mekatok.framework.stomp.configure.EnableWsStomp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

/**
 * Demo项目启动类
 * @author GuoKai
 * @date 2021/8/17
 */
@Slf4j
@EnableWsStomp
@EnableRedisCache
@MekatokApplication
@EnableSimpleSecurity
@EnableCustomFlowable
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
