package icu.guokai.mekatok.framework.plugin.async;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 异步任务执行器 和 定时任务执行器 配置
 * @author GuoKai
 * @date 2021/8/22
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({TaskExecutorConfig.class, TaskSchedulerConfig.class})
public @interface EnableTask {
}
