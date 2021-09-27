package icu.guokai.mekatok.framework.plugin.event;

import icu.guokai.mekatok.framework.core.event.Event;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpHeaders;

/**
 * router 被调用后事件
 * @author GuoKai
 * @date 2021/9/6
 */
@Accessors
public class RouterCallAfter extends Event<Object> {

    private static final long serialVersionUID = 5159466480377453578L;

    /**
     * 请求头
     */
    @Getter
    @Setter
    private HttpHeaders headers;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RouterCallAfter(Object source) {
        super(source);
    }

    @Override
    public String description() {
        return "Router被调用后";
    }

}
