package mekatok.application.event;

import mekatok.core.definition.EventType;

/**
 * 命令对象
 * @author GuoCay
 * @since 2023/3/6
 */
public abstract class CommandEventObject extends AbstractEventObject {

    @Override
    public EventType getEventType() {
        return EventType.COMMAND;
    }
}
