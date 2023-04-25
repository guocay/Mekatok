package icu.guokai.mekatok.framework.plugin.async;

import cn.hutool.extra.spring.SpringUtil;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;

/**
 * 异步执行器 配置
 * @author GuoKai
 * @date 2021/8/22
 */
@Slf4j
@EnableAsync
@Configuration
@SuppressWarnings("all")
public class TaskExecutorConfig {

    /**
     * 配置 异步任务执行器
     * @return 任务执行器
     */
    @Bean
    @Primary
    public AsyncTaskExecutor asyncTaskExecutor(){
        var executor = new TaskExecutorBuilder().corePoolSize(10)
                .maxPoolSize(20).queueCapacity(500).keepAlive(Duration.ofSeconds(60l))
                .threadNamePrefix(Global.TASK_EXECUTOR_PREFIX).build();
        return executor;
    }

    /**
     * 声明异步的启动后任务
     * @return ApplicationRunner
     */
    @Bean
    public ApplicationRunner afterApplicationStart(AsyncTaskExecutor executor){
        return args -> SpringUtil.getBeansOfType(AsyncTask.class).values()
                .forEach(task -> executor.execute(task,task.startTimeout()));
    }

}
