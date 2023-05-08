package mekatok.core.component.container;

/**
 * 分页容器 消息头 构造者
 * @author GuoCay
 * @since 2023.03.10
 */
public class PageHeadBuilder implements IContainerHeadBuilder{

    /**
     * 总页数
     */
    private Long total;

    /**
     * 偏移量 起
     */
    private Long offsets;

    /**
     * 偏移量 止
     */
    private Long limit;

    public static PageHeadBuilder builder(){
        return new PageHeadBuilder();
    }

    /**
     * 获取分页容器构造者
     * @param total 总数
     * @param offsets 从
     * @param limit 至
     * @return 构造者
     */
    public static PageHeadBuilder builder(Long total, Long offsets, Long limit){
        return builder().total(total).offsets(offsets).limit(limit);
    }

    /**
     * 设置总数
     * @param total 总数
     * @return 构造者
     */
    public PageHeadBuilder total(Long total) {
        this.total = total;
        return this;
    }

    /**
     * 设置 从第几条开始
     * @param offsets 从第几条开始
     * @return 构造者
     */
    public PageHeadBuilder offsets(Long offsets) {
        this.offsets = offsets;
        return this;
    }

    /**
     * 设置 至第几条结束
     * @param limit 至第几条结束
     * @return 构造者
     */
    public PageHeadBuilder limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public IContainerHead build(){
        return new PageHead(total, offsets, limit);
    }

    private PageHeadBuilder(){}
}
