package com.github.guokaia.mekatok.context.event;

import com.github.guokaia.mekatok.context.spring.SpringContextHolder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring Event 操作静态工具类
 * @author GuoKai
 * @date 2022/2/1
 */
@EnableAsync
public class SpringEventHolder {

    private SpringEventHolder(){}

    /**
     * 发布事件至 Spring
     * @param event 事件数据
     */
    public static void publish(AbstractEvent<?> event){
        publish((Object) event);
    }

    public static void publish(Object event){
        SpringContextHolder.publishEvent(event);
    }
}
