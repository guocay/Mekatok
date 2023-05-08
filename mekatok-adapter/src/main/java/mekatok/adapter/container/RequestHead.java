package mekatok.adapter.container;

import mekatok.core.component.container.ContainerType;
import mekatok.core.component.container.IContainerHead;

import static mekatok.core.component.container.ContainerType.REQUEST;

/**
 * 请求对象
 * @author GuoCay
 * @since 2023.03.09
 */
public class RequestHead implements IContainerHead {

    /**
     * 调用者
     */
    private final Long callerId;

    /**
     * 请求ID
     */
    private final Long requestId;

    public RequestHead(Long callerId, Long requestId) {
        this.callerId = callerId;
        this.requestId = requestId;
    }

    @Override
    public ContainerType getType() {
        return REQUEST;
    }
}
