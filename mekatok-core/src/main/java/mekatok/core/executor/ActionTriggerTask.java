package mekatok.core.executor;

/**
 * 事件(行为)触发的任务 - 用于通过事件触发的任务
 * @author GuoCay
 * @since 2023/3/6
 */
public interface ActionTriggerTask<ACTION> extends Task {

    /**
     * 获取事件(行为)信息
     * @return 事件(行为)
     */
    ACTION getAction();
}
