package mekatok.application.exec;

import mekatok.application.event.EventContext;
import mekatok.core.executor.ApplicationExecutor;

/**
 * 领域服务编排(布局)
 * @author aCay
 * @since 2023/3/6
 */
public abstract class AbstractApplicationExecutor implements ApplicationExecutor {

    /**
     * 准备执行
     * @param context 事件上下文
     */
    abstract void prepareExec(EventContext context);
}

