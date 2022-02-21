package com.github.guokaia.mekatok.context.thread;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 线程池 属性
 * @author GuoKai
 * @date 2022/2/1
 */
@Data
@ConfigurationProperties(prefix = "mekatok.thread-pool")
public class ThreadPoolProperties {

    /**
     * 是否使用 ForkJoinPool 线程池
     */
    private Boolean useForkJoinPool = true;

    /**
     * 核心线程数
     */
    private Integer corePoolSize = 16;

    /**
     * 最大线程数
     */
    private Integer maxPoolSize = 16;

    /**
     * 等待时间
     */
    private Integer keepAliveSeconds = 10;

    /**
     * 队列大小
     */
    private Integer queueCapacity = 32;
}
