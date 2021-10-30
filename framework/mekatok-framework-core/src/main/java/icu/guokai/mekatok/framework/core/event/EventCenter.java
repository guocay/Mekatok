package icu.guokai.mekatok.framework.core.event;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Spring Event 操作工具类
 * @author GuoKai
 * @date 2021/8/31
 */
@Slf4j
public abstract class EventCenter {

    /**
     * 发布事件至 Spring
     * @param event 事件对象
     */
    public static void publish(Event<?> event){
        var element = ThreadUtil.getStackTraceElement(4);
        log.info("{} 发布了事件: {}, 内容为: {}",
                String.format("%s.%s()",element.getClassName(),element.getMethodName()),
                event.description(), JSONUtil.toJsonStr(event.getSource()));
        SpringUtil.getApplicationContext().publishEvent(event);
    }
}
