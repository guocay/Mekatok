package mekatok.core.util.concurrent;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.MAX_PRIORITY;

/**
 * 构造者设计模式下的线程构造者
 * @author aCay
 * @since 2023.03.10
 */
public class ThreadPoolBuilder {

    private static final Integer DEFAULT_MAX_QUEUE_SIZE = 10;

    private ThreadGroup group;

    private String threadPoolName = "custom-threadpool";

    private String threadName = "thread";

    private Boolean daemon = false;

    private Integer priority = MAX_PRIORITY;

    private Integer corePoolSize;

    private Integer maximumPoolSize;

    private Long keepAliveTime = 60 * 1000L;

    private Integer maxQueueSize = 10;

    private BlockingQueue<Runnable> workQueue;

    private ThreadFactory threadFactory;

    private RejectedExecutionHandler reject = new ThreadPoolExecutor.AbortPolicy();

    private ThreadPoolBuilder(){}

    /**
     * 获取线程池构建者
     * @return 线程池构建者
     */
    public static ThreadPoolBuilder builder(){
        return new ThreadPoolBuilder();
    }

    public ExecutorService build(){
        // 生成 阻塞队列
        if (workQueue == null)
            workQueue = new LinkedBlockingQueue<>(maxQueueSize);
        // 生成 线程工厂
        if (threadFactory == null)
            threadFactory = buildThreadFactory();
        // 生成 核心线程数 和 最大线程数
        if (corePoolSize == null)
            corePoolSize = Runtime.getRuntime().availableProcessors();
        if (maximumPoolSize == null)
            maximumPoolSize = corePoolSize * 2;
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                workQueue, threadFactory, reject);
    }

    /**
     * 设置 线程组.  副作用会清空threadFactory属性.
     * @param group 线程组
     * @return 构造者
     */
    public ThreadPoolBuilder group(ThreadGroup group) {
        this.group = group;
        this.threadFactory = null;
        return this;
    }

    /**
     * 设置 线程池名称,  副作用会清空threadFactory属性.
     * @param threadPoolName 线程池名称
     * @return 构造者
     */
    public ThreadPoolBuilder threadPoolName(String threadPoolName) {
        this.threadPoolName = threadPoolName;
        this.threadFactory = null;
        return this;
    }

    /**
     * 设置 线程名称. 副作用会清空threadFactory属性.
     * @param threadName 线程名称
     * @return 构造者
     */
    public ThreadPoolBuilder threadName(String threadName) {
        this.threadName = threadName;
        this.threadFactory = null;
        return this;
    }

    /**
     * 设置 线程是否守护线程. 副作用会清空threadFactory属性.
     * @param daemon 是否守护
     * @return 构造者
     */
    public ThreadPoolBuilder daemon(Boolean daemon) {
        this.daemon = daemon;
        this.threadFactory = null;
        return this;
    }

    /**
     * 设置 线程优先级,  副作用会清空threadFactory属性.<br/>
     * @param priority 优先级
     * @return 构造者
     */
    public ThreadPoolBuilder priority(Integer priority) {
        checkPositive(priority);
        this.priority = priority;
        this.threadFactory = null;
        return this;
    }

    /**
     * 设置核心线程数
     * @param corePoolSize 核心线程数
     * @return 构造者
     */
    public ThreadPoolBuilder corePoolSize(Integer corePoolSize) {
        checkPositive(corePoolSize);
        this.corePoolSize = corePoolSize;
        return this;
    }

    /**
     * 设置最大线程数
     * @param maximumPoolSize 最大线程数
     * @return 构造者
     */
    public ThreadPoolBuilder maximumPoolSize(Integer maximumPoolSize) {
        checkPositive(maximumPoolSize);
        this.maximumPoolSize = maximumPoolSize;
        return this;
    }

    /**
     * 设置 空闲线程的等待时间 单位: 毫秒
     * @param keepAliveTime 空闲等待时间
     * @return 构造者
     */
    public ThreadPoolBuilder keepAliveTime(Long keepAliveTime) {
        checkPositive(keepAliveTime);
        this.keepAliveTime = keepAliveTime;
        return this;
    }

    /**
     * 设置最大队列容量, 副作用会清空 workQueue属性
     * @param maxQueueSize 队列最大容量
     * @return 构造者
     */
    public ThreadPoolBuilder maxQueueSize(Integer maxQueueSize) {
        checkPositive(maxQueueSize);
        this.maxQueueSize = maxQueueSize;
        this.workQueue = null;
        return this;
    }

    /**
     * 设置 线程池使用的阻塞队列
     * @param workQueue 阻塞队列
     * @return 构造者
     */
    public ThreadPoolBuilder workQueue(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        return this;
    }

    /**
     * 设置 线程工厂
     * @param threadFactory 线程工厂
     * @return 构造者
     */
    public ThreadPoolBuilder threadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        return this;
    }

    /**
     * 设置 拒绝策略
     * @param reject 拒绝策略
     * @return 构造者
     */
    public ThreadPoolBuilder reject(RejectedExecutionHandler reject) {
        this.reject = reject;
        return this;
    }

    private void checkPositive(Number number){
        if (number.doubleValue() < 0)
            throw new RuntimeException("this is not positive integer.");
    }


    /**
     * 构建线程工厂
     * @return 线程工厂
     */
    private ThreadFactory buildThreadFactory() {
        return new CustomThreadFactory(group, threadPoolName, threadName, daemon, priority);
    }

    private static class CustomThreadFactory implements ThreadFactory{
        private static final String THREAD_NAME_FORMAT = "[%d] %s-%s";

        private static final AtomicInteger threadNumber = new AtomicInteger(1);

        private final ThreadGroup group;

        private final String threadPoolName;

        private final String threadName;

        private final Boolean daemon;

        private final Integer priority;

        private CustomThreadFactory(ThreadGroup group, String threadPoolName, String threadName,
                                    Boolean daemon, Integer priority) {
            this.group = Optional.ofNullable(group).orElse(Thread.currentThread().getThreadGroup());
            this.threadPoolName = threadPoolName;
            this.threadName = threadName;
            this.daemon = daemon;
            this.priority = priority;
        }

        @Override
        public Thread newThread(Runnable run) {
            String name = String.format(THREAD_NAME_FORMAT, threadNumber.getAndIncrement(), threadPoolName, threadName);
            Thread thread = new Thread(group, run, threadName);
            thread.setDaemon(daemon);
            thread.setPriority(priority);
            return thread;
        }
    }

}
