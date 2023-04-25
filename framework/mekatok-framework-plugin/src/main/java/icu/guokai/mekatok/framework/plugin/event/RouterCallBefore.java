package icu.guokai.mekatok.framework.plugin.event;

import icu.guokai.mekatok.framework.core.event.Event;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletRequest;

/**
 * Router 被调用前
 * @author GuoKai
 * @date 2021/9/6
 */
@Accessors
public class RouterCallBefore extends Event<HttpServletRequest> {

    private static final long serialVersionUID = 1483821074874527140L;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RouterCallBefore(HttpServletRequest source) {
        super(source);
    }

    @Override
    public String description() {
        return "Router被调用前";
    }

}
