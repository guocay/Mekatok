package mekatok.application.event;

import mekatok.core.definition.EventType;

/**
 * 查询对象
 * @author GuoCay
 * @since 2023/3/6
 */
public abstract class QueryEventObject extends AbstractEventObject {

    @Override
    public EventType getEventType() {
        return EventType.QUERY;
    }
}
