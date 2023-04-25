package mekatok.adapter.container;

import mekatok.core.component.container.IContainerHead;
import mekatok.core.component.container.IContainerHeadBuilder;

/**
 * 消息队列 的消息头 构造者
 * @author aCay
 * @since 2023.03.10
 */
public class MessageHeadBuilder implements IContainerHeadBuilder {

    public static MessageHeadBuilder builder(){
        return new MessageHeadBuilder();
    }

    @Override
    public IContainerHead build() {
        return new MessageHead();
    }

    private MessageHeadBuilder(){}
}
