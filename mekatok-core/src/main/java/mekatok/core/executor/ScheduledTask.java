package mekatok.core.executor;

/**
 * 可调度的任务 - 适用于一些延迟, 周期调度的任务.
 * @author aCay
 * @since 2023/3/6
 */
public interface ScheduledTask extends Task {

	/**
	 * 获取 延迟执行时间 以毫秒为单位
	 * @return 延迟执行时间
	 */
	long getDelayTime();

	/**
	 * 获取 执行周期间隔 以毫秒为单位
	 * @return 执行周期间隔
	 */
	long getCycleTime();

	/**
	 * 获取 是否周期性任务
	 * @return 是否周期性任务
	 */
	boolean isPeriodic();

}
