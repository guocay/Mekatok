package mekatok.adapter.container;

import mekatok.core.component.container.IContainerHead;
import mekatok.core.component.container.IContainerHeadBuilder;

/**
 * 请求容器 消息头
 * @author GuoCay
 * @since 2023.03.10
 */
public class RequestHeadBuilder implements IContainerHeadBuilder {

    private Long callerId;

    private Long requestId;

    public static RequestHeadBuilder builder(){
        return new RequestHeadBuilder();
    }

    /**
     * 获取请求消息头
     * @param callId 请求调用方标识
     * @return 构造者
     */
    public static RequestHeadBuilder builder(Long callId){
        return builder().callerId(callId);
    }

    /**
     * 设置 调用者标识
     * @param callerId 调用者标识
     * @return 构造者
     */
    public RequestHeadBuilder callerId(Long callerId) {
        this.callerId = callerId;
        return this;
    }

    /**
     * 设置 请求ID
     * @param requestId 请求ID
     * @return 构造者
     */
    public RequestHeadBuilder requestId(Long requestId) {
        this.requestId = requestId;
        return this;
    }

    @Override
    public IContainerHead build() {
        return new RequestHead(callerId, requestId);
    }

    private RequestHeadBuilder() {
    }
}
