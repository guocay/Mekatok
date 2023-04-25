package mekatok.core.component.container;

import java.util.List;

/**
 * 默认的对象容器
 * @author aCay
 * @since 2023.03.09
 */
public class DefaultContainer<T> implements IContainer<T>{

    /**
     * 容器头
     */
    private final IContainerHead head;

    /**
     * 容器体
     */
    private final List<T> body;

    public DefaultContainer(IContainerHead head, List<T> body) {
        this.head = head;
        this.body = body;
    }

    @Override
    public IContainerHead getHead() {
        return head;
    }

    @Override
    public List<T> getBody() {
        return body;
    }
}
