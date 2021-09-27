package icu.guokai.mekatok.framework.core.plugin;

import icu.guokai.mekatok.framework.core.event.Listener;

/**
 * 插件基类
 * @author GuoKai
 * @date 2021/9/23
 */
@SuppressWarnings("all")
public interface Plugin<T extends Activity<?>> extends Listener<T> {

    /**
     * 判断是否执行当前插件
     * @param activity 依赖对象
     * @return 操作与否
     */
    boolean support(T activity);

    /**
     * 执行 插件内 函数
     * @param event 活动数据
     */
    @Override
    default void onApplicationEvent(T event){
        if(support(event)){
            action(event);
            event.addPlugin(getClass());
        }
    }
}
