package icu.guokai.mekatok.framework.core.plugin;

import cn.hutool.extra.spring.SpringUtil;
import icu.guokai.mekatok.framework.core.event.EventCenter;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 插件使用中心
 * @author GuoKai
 * @date 2021/9/23
 */
@SuppressWarnings("all")
public abstract class PluginCenter {

    /**
     * 发布活动,执行插件.
     * @param activity 活动
     * @param <T> 泛型
     */
    public static <T extends Activity<?>> void script(T activity){
        script(activity, Activity::success, (item, throwable) -> item.failure(throwable));
    }

    /**
     * 发布活动,执行插件.回调的优先级高于activity中的定义.
     * @param activity 活动
     * @param success 成功回调
     * @param <T> 泛型
     */
    public static <T extends Activity<?>> void script(T activity, Consumer<T> success){
        script(activity, Activity::success, (item,Throwable) -> {});
    }

    /**
     * 发布活动,执行插件.回调的优先级高于activity中的定义.
     * @param activity 活动
     * @param failure 失败回调
     * @param <T> 泛型
     */
    public static <T extends Activity<?>> void script(T activity, BiConsumer<T, Throwable> failure){
        script(activity, (item) -> {}, failure);
    }

    /**
     * 发布活动,执行插件.回调的优先级高于activity中的定义.
     * @param activity 活动
     * @param success 成功回调
     * @param failure 失败回调
     * @param <T> 泛型
     */
    public static <T extends Activity<?>> void script(T activity, Consumer<T> success, BiConsumer<T, Throwable> failure){
        try {
            EventCenter.publish(activity);
            success.accept(activity);
        }catch (Throwable throwable){
            failure.accept(activity, throwable);
        }
    }

    /**
     * 获取插件总数
     */
    public static <T extends Activity<?>> Integer count(Class<T> activity){
        return getPlugins(activity).size();
    }

    /**
     * 判断是否包含某个活动的插件
     */
    public static <T extends Activity<?>> boolean hasPlugin(Class<T> activity){
        return count(activity) > 0;
    }

    /**
     * 获取所有插件
     */
    public static <T extends Activity<?>> List<Plugin> getPlugins(Class<T> activity){
        return SpringUtil.getBeansOfType(Plugin.class).values().stream()
                .filter(plugin -> plugin.getClass().equals(activity)).collect(Collectors.toList());
    }
}
