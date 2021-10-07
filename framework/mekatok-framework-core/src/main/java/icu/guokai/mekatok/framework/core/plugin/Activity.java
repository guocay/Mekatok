package icu.guokai.mekatok.framework.core.plugin;

import cn.hutool.core.collection.CollUtil;
import icu.guokai.mekatok.framework.core.event.Event;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 插件所依赖的活动
 * @author GuoKai
 * @date 2021/9/23
 */
@SuppressWarnings("all")
public abstract class Activity<T> extends Event<T> {

    private static final long serialVersionUID = 6996847203171194108L;

    /**
     * 日志对象
     */
    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 用于存储活动已执行的插件
     */
    @Getter
    private List<Class<? extends Plugin>> plugins = CollUtil.newLinkedList();

    /**
     * 构造器
     * @param source 元数据
     */
    public Activity(T source) {
        super(source);
    }

    /**
     * 插件执行失败时的回调
     */
    protected void success(){
        log.info("活动 {}, 执行成功!", name());
    }

    /**
     * 插件执行成功时的回调
     * @param throwable 异常信息
     */
    protected void failure(Throwable throwable){
        log.error("活动 {}, 执行错误!", name());
        log.error(throwable.getMessage(), throwable);
    }

    /**
     * 添加当前活动已执行成功的插件
     * @param plugin 已执行过的插件
     */
    protected <F extends Plugin> void addPlugin(Class<F> plugin){
        plugins.add(plugin);
    }

    /**
     * 活动名称
     */
    @Override
    public String name() {
        return super.name();
    }

    /**
     * 活动备注
     */
    @Override
    public String description() {
        return super.description();
    }

    /**
     * 活动元数据
     */
    @Override
    public T getMeta() {
        return super.getMeta();
    }
}
