package mekatok.core.component.container;

/**
 * 分页容器头信息
 * @author GuoCay
 * @since 2023.03.09
 */
public class PageHead implements IContainerHead {

    /**
     * 总数
     */
    private final Long total;

    /**
     * 从第几条开始
     */
    private final Long offsets;

    /**
     * 到第几条结束
     */
    private final Long limit;

    public PageHead(Long total, Long offsets, Long limit) {
        if(total < 0 || offsets < 0 || limit < 0)
            throw new UnsupportedOperationException("not a positive number");
        if(limit > total)
            throw new UnsupportedOperationException("limit not greater than total");
        if(offsets > limit)
            throw new UnsupportedOperationException("offsets not greater than limit");
        this.total = total;
        this.offsets = offsets;
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public Long getOffsets() {
        return offsets;
    }

    public Long getLimit() {
        return limit;
    }

    @Override
    public ContainerType getType() {
        return ContainerType.PAGE;
    }
}
