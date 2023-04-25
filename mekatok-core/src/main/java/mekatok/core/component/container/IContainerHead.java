package mekatok.core.component.container;

/**
 * 容器 消息头
 * @author aCay
 * @since 2023.03.09
 */
public interface IContainerHead {

    /**
     * 获取容器类型
     * @return 容器类型
     */
    ContainerType getType();

    /**
     * 是否 其他消容器的消息头
     * @return 其他消息头
     */
    default boolean isOther(){
        return ContainerType.OTHER == getType();
    }
    /**
     * 是否 分页容器消息头
     * @return 是否分页消息头
     */
    default boolean isPage() {
        return ContainerType.PAGE == getType();
    }

    /**
     * 是否 响应容器消息头
     * @return 是否响应消息
     */
    default boolean isResponse(){
        return ContainerType.RESPONSE == getType();
    }

    /**
     * 是否 请求容器消息头
     * @return 请求消息头
     */
    default boolean isRequest(){
        return ContainerType.REQUEST == getType();
    }

    /**
     * 是否 消息队列容器的消息头
     * @return 其他消息头
     */
    default boolean isMessage(){
        return ContainerType.MESSAGE == getType();
    }
}
