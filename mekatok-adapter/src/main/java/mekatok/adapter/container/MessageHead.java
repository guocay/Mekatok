package mekatok.adapter.container;

import mekatok.core.component.container.ContainerType;
import mekatok.core.component.container.IContainerHead;

import static mekatok.core.component.container.ContainerType.MESSAGE;

/**
 * 消息队列消息头
 * @author aCay
 * @since 2023.03.09
 */
public class MessageHead implements IContainerHead {

    @Override
    public ContainerType getType() {
        return MESSAGE;
    }
}
