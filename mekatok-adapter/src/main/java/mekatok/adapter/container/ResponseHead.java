package mekatok.adapter.container;

import mekatok.core.component.container.ContainerType;
import mekatok.core.component.container.IContainerHead;

import static mekatok.core.component.container.ContainerType.RESPONSE;

/**
 * 返回值容器对象
 * @author aCay
 * @since 2023.03.09
 */
public class ResponseHead implements IContainerHead {

    /**
     * 请求对象
     */
    private final Long requestId;

    /**
     * 成功
     */
    private final Boolean success;

    /**
     * 错误信息
     */
    private final String mistake;


    public ResponseHead(Long requestId, Boolean success) {
        this(requestId, success, null);
    }

    public ResponseHead(Long requestId, Boolean success, String mistake) {
        this.requestId = requestId;
        this.success = success;
        this.mistake = mistake;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMistake() {
        return mistake;
    }

    @Override
    public ContainerType getType() {
        return RESPONSE;
    }
}
