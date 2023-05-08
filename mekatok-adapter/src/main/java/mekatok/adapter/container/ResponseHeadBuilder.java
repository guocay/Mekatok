package mekatok.adapter.container;

import mekatok.core.component.container.IContainerHead;
import mekatok.core.component.container.IContainerHeadBuilder;

/**
 * 响应容器的 消息头
 * @author GuoCay
 * @since 2023.03.10
 */
public class ResponseHeadBuilder implements IContainerHeadBuilder {

    /**
     * 请求对象
     */
    private Long requestId;

    /**
     * 成功
     */
    private Boolean success = true;

    /**
     * 错误信息
     */
    private String mistake;

    public static ResponseHeadBuilder builder(){
        return new ResponseHeadBuilder();
    }

    /**
     * 获取响应对象
     * @param success 是否成功
     * @return 构造者
     */
    public static ResponseHeadBuilder builder(Boolean success){
        return builder().success(success);
    }

    /**
     * 设置 请求ID
     * @param requestId 请求ID
     * @return 构造者
     */
    public ResponseHeadBuilder requestId(Long requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * 设置 是否成功
     * @param success 是否成功
     * @return 构造者
     */
    public ResponseHeadBuilder success(Boolean success) {
        if (success != null)
            this.success = success;
        return this;
    }

    /**
     * 设置 错误信息
     * @param mistake 错误信息
     * @return 构造者
     */
    public ResponseHeadBuilder mistake(String mistake) {
        this.mistake = mistake;
        return this;
    }

    @Override
    public IContainerHead build() {
        return new ResponseHead(requestId, success, mistake);
    }

    private ResponseHeadBuilder() {
    }
}
