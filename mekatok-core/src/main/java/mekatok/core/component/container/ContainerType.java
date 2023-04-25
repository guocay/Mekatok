package mekatok.core.component.container;

/**
 * 容器类型 枚举
 * @author aCay
 * @since 2023.03.09
 */
public enum ContainerType {

    /**
     * 其他
     */
    OTHER(0),
    /**
     * 分页
     */
    PAGE(1),
    /**
     * 请求
     */
    REQUEST(2),
    /**
     * 响应
     */
    RESPONSE(3),
    /**
     * 消息队列请求
     */
    MESSAGE(4);

    private final int type;

    ContainerType(int type) {
        this.type = type;
    }
}
