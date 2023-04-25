package mekatok.core.component.container;

import java.util.Arrays;
import java.util.List;

/**
 * 容器工厂 构造者模式
 * @author aCay
 * @since 2023.03.10
 */
public class ContainerBuilder<T> implements IBuilder<IContainer<T>> {

    protected IContainerHead head;

    protected List<T> body;

    /**
     * 获取一个容器构造者
     * @param builder 消息头构造者
     * @return 构造者
     * @param <T> 泛型
     */
    public static <T> ContainerBuilder<T> builder(IContainerHeadBuilder builder){
        return ContainerBuilder.<T>builder().head(builder);
    }

    /**
     * 获取一个容器构造者
     * @param head 消息头
     * @return 构造者
     * @param <T> 泛型
     */
    public static <T> ContainerBuilder<T> builder(IContainerHead head){
        return ContainerBuilder.<T>builder().head(head);
    }

    public static <T> ContainerBuilder<T> builder(){
        return new ContainerBuilder<>();
    }

    /**
     * 设置容器的消息头
     * @param head 消息头
     * @return 构造者
     */
    public ContainerBuilder<T> head(IContainerHead head) {
        this.head = head;
        return this;
    }

    /**
     * 设置容器的消息头
     * @param builder 消息头构造者
     * @return 构造者
     */
    public ContainerBuilder<T> head(IContainerHeadBuilder builder){
        return head(builder.build());
    }

    /**
     * 设置容器的消息体
     * @param body 消息体
     * @return 构造者
     */
    public ContainerBuilder<T> body(List<T> body) {
        this.body = body;
        return this;
    }

    /**
     * 设置容器的消息体
     * @param body 消息体
     * @return 构造者
     */
    public final ContainerBuilder<T> body(T body) {
        this.body = Arrays.asList(body);
        return this;
    }

    public IContainer<T> build(){
        return new DefaultContainer<T>(head, body);
    }

    private ContainerBuilder() {}
}
