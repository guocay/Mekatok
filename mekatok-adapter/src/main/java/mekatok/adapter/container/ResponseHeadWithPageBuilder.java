package mekatok.adapter.container;

import mekatok.core.component.container.IContainerHead;
import mekatok.core.component.container.IContainerHeadBuilder;
import mekatok.core.component.container.PageHead;
import mekatok.core.component.container.PageHeadBuilder;

/**
 * 带分页的容器 消息头
 * @author aCay
 * @since 2023.03.10
 */
public class ResponseHeadWithPageBuilder implements IContainerHeadBuilder {

    private ResponseHead response;

    private PageHead page;

    /**
     * 获取带分页的容器 构造者
     * @param requestId 请求ID
     * @param success 是否成功
     * @param mistake 错误信息
     * @return 构造者
     */
    public static ResponseHeadWithPageBuilder builder(Long requestId, Boolean success, String mistake){
        return builder(ResponseHeadBuilder.builder(success).requestId(requestId).mistake(mistake));
    }

    /**
     * 获取带分页的容器 构造者
     * @param builder 构造者
     * @return 构造者
     */
    public static ResponseHeadWithPageBuilder builder(ResponseHeadBuilder builder){
        return builder((ResponseHead)builder.build());
    }

    /**
     * 获取带分页的容器 构造者
     * @param response 响应消息对象
     * @return 构造者
     */
    public static ResponseHeadWithPageBuilder builder(ResponseHead response){
        return builder().response(response);
    }

    public static ResponseHeadWithPageBuilder builder(){
        return new ResponseHeadWithPageBuilder();
    }

    /**
     * 设置带分页的响应消息容器
     * @param total 总数
     * @param offset 从
     * @param limit 至
     * @return 构造者
     */
    public ResponseHeadWithPageBuilder page(Long total, Long offset, Long limit) {
        return page(PageHeadBuilder.builder(total, offset, limit));
    }

    /**
     * 设置带分页的响应消息容器
     * @param builder 构造者
     * @return 构造者
     */
    public ResponseHeadWithPageBuilder page(PageHeadBuilder builder) {
        return page((PageHead) builder.build());
    }

    /**
     * 设置带分页的响应消息容器
     * @param page 分页消息对象
     * @return 构造者
     */
    public ResponseHeadWithPageBuilder page(PageHead page) {
        this.page = page;
        return this;
    }

    public ResponseHeadWithPageBuilder response(ResponseHead response) {
        this.response = response;
        return this;
    }

    @Override
    public IContainerHead build() {
        return new ResponseHeadWithPage(response, page);
    }

    private ResponseHeadWithPageBuilder(){}
}
