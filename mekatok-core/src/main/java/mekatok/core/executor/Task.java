package mekatok.core.executor;

/**
 * 适配器中的任务接口 - 适用于一些自启动的任务.
 * @author aCay
 * @since 2023/3/6
 */
public interface Task extends Runnable {

    /**
     * 获取任务名称
     * @return 名称
     */
    String getTaskName();
}
