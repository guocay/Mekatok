package icu.guokai.mekatok.framework.core.event;

import icu.guokai.mekatok.framework.core.model.Model;
import org.springframework.context.ApplicationEvent;

/**
 * 平台内对于应用事件的包装
 * @author GuoKai
 * @date 2021/8/31
 */
public abstract class Event<T> extends ApplicationEvent implements Model {

    private static final long serialVersionUID = 905529385550550456L;

    /**
     * 构造器
     * @param source 元数据
     */
    public Event(T source) {
        super(source);
    }

    /**
     * 事件名称
     * @return 事件名称
     */
    public String name(){
        return getClass().getName();
    };

    /**
     * 事件备注
     * @return 事件备注
     */
    public String description(){
        return "默认事件描述";
    }

    /**
     * 事件数据
     * @return 事件数据
     */
    public T getMeta() {
        return (T) getSource();
    }

}
