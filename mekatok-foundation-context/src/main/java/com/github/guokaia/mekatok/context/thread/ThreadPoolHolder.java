package com.github.guokaia.mekatok.context.thread;

import com.github.guokaia.mekatok.common.Global;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * 线程池 静态工具类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
@Component
public class ThreadPoolHolder implements BeanFactoryAware {

    private ThreadPoolHolder(){}

    /**
     * 线程池
     */
    private static Executor executor;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ThreadPoolHolder.executor = beanFactory.getBean(Global.THREAD_POOL_BEAN_NAME, Executor.class);
    }

    /**
     * 异步执行
     * @param runnable 需执行的线程
     */
    public static void execute(Runnable runnable){
        executor.execute(runnable);
    }
}
