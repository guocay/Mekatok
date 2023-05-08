package mekatok.application.event;

import mekatok.core.definition.EventObject;

/**
 * 抽象的事件对象
 * @author GuoCay
 * @since 2023.03.09
 */
public abstract class AbstractEventObject implements EventObject {

    /**
     * 获取事件的附件信息
     * @return 事件的附件信息
     */
    abstract EventContext getContext();
}
