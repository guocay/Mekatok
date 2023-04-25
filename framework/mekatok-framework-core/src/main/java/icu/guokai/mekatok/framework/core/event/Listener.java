package icu.guokai.mekatok.framework.core.event;

import icu.guokai.mekatok.framework.core.asserts.WithAssertions;
import org.springframework.context.ApplicationListener;

/**
 * 事件监听的基类
 * @author GuoKai
 * @date 2021/9/27
 */
@SuppressWarnings("all")
public interface Listener<T extends Event<?>> extends ApplicationListener<T>, WithAssertions {

    /**
     * 事件执行函数
     * @param event 依赖对象
     */
    void action(T event) throws RuntimeException;

    /**
     * 重写 ApplicationListener 的事件响应函数,用于执行action()
     * @param event 元数据
     */
    @Override
    default void onApplicationEvent(T event){
        action(event);
    }
}
