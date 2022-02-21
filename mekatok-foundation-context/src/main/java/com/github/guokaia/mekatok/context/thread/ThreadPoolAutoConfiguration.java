package com.github.guokaia.mekatok.context.thread;

import com.github.guokaia.mekatok.common.Global;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池自定义配置
 * @author GuoKai
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@EnableAsync
@Configuration(proxyBeanMethods = false)
@Import(ThreadPoolHolder.class)
@EnableConfigurationProperties(ThreadPoolProperties.class)
public class ThreadPoolAutoConfiguration implements AsyncConfigurer {

    private final ThreadPoolProperties properties;

    public ThreadPoolAutoConfiguration(ThreadPoolProperties properties) {
        this.properties = properties;
    }

    @Override
    @Bean(Global.THREAD_POOL_BEAN_NAME)
    public Executor getAsyncExecutor() {
        // 三目运算符
        return properties.getUseForkJoinPool() ?
            new ForkJoinPool() :
            new ThreadPoolExecutor(
                properties.getCorePoolSize(), properties.getMaxPoolSize(),
                properties.getKeepAliveSeconds(), TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(properties.getQueueCapacity()),
                buildThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy()
            );
    }

    /**
     * 创建 线程工厂
     * @return 线程工厂
     */
    private ThreadFactory buildThreadFactory(){
        return new ThreadFactory() {
            private final AtomicLong number = new AtomicLong();
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                thread.setName(String.format("%s%d", Global.THREAD_POOL_NAME_PREFIX, number.getAndIncrement()));
                return thread;
            }
        };
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            // todo 可以在这里做一些线程池异常处理的逻辑
        };
    }
}
