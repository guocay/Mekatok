package mekatok.adapter.container;

import mekatok.core.component.container.PageHead;

/**
 * 带分页的响应容器对象
 * @author aCay
 * @since 2023.03.09
 */
public class ResponseHeadWithPage extends ResponseHead{

    /**
     * 分页信息
     */
    private final PageHead page;

    /**
     * 创建一个带分页的响应容器
     * @param requestId 请求ID
     * @param success 是否成功
     * @param total 总数
     * @param offsets 从
     * @param limit 至
     */

    public ResponseHeadWithPage(Long requestId, Boolean success, Long total, Long offsets, Long limit) {
        this(requestId, success, null, total, offsets, limit);
    }

    /**
     * 创建一个带分页的响应容器
     * @param requestId 请求ID
     * @param success 是否成功
     * @param mistake 错误信息
     * @param total 总数
     * @param offsets 从
     * @param limit 至
     */
    public ResponseHeadWithPage(Long requestId, Boolean success, String mistake, Long total, Long offsets, Long limit) {
        this(requestId, success, mistake, new PageHead(total, offsets, limit));
    }

    /**
     * 创建一个带分页的响应容器
     * @param requestId 请求ID
     * @param success 是否成功
     * @param mistake 错误信息
     * @param page 分页信息
     */
    public ResponseHeadWithPage(Long requestId, Boolean success, String mistake, PageHead page) {
        super(requestId, success, mistake);
        this.page = page;
    }

    public ResponseHeadWithPage(ResponseHead head, PageHead page){
        this(head.getRequestId(), head.getSuccess(), head.getMistake(), page);
    }
}
