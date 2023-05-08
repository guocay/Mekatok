package mekatok.core.component.container;

/**
 * 容器 消息头 构造者 接口
 * @author GuoCay
 * @since 2023.03.10
 */
public interface IContainerHeadBuilder extends IBuilder<IContainerHead>{

    /**
     * 构造者 执行构建
     * @return 消息头
     */
    IContainerHead build();
}
