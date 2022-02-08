package com.github.guokaia.mekatok.context.thread;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 任务调度管理
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@EnableScheduling
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(ThreadPoolAutoConfiguration.class)
public class TaskSchedulingAutoConfiguration {
}
