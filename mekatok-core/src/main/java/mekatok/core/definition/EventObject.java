package mekatok.core.definition;

/**
 * 事件对象
 * @author GuoCay
 * @since 2023/3/6
 */
public interface EventObject extends Definition{

    /**
     * 获取事件类型
     * @return 事件类型
     */
    default EventType getEventType(){
        return EventType.OTHER;
    }
}
