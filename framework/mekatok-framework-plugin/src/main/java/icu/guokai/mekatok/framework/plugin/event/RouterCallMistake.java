package icu.guokai.mekatok.framework.plugin.event;

import icu.guokai.mekatok.framework.core.event.Event;
import lombok.experimental.Accessors;

/**
 * @author GuoKai
 * @date 2021/9/8
 */
@Accessors
public class RouterCallMistake extends Event<Throwable> {

    private static final long serialVersionUID = 3954623921195154741L;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RouterCallMistake(Throwable source) {
        super(source);
    }

    @Override
    public String description() {
        return "Router调用异常";
    }

}
