package mekatok.core.component.container;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 容器对象
 * @author GuoCay
 * @since 2023.03.09
 */
public interface IContainer<T> {

    /**
     * 获取容器 消息头
     * @return 消息头
     */
    IContainerHead getHead();

    /**
     * 获取容器 消息体
     * @return 消息体
     */
    List<T> getBody();

    /**
     * 获取容器类型
     * @return 容器类型
     */
    default ContainerType getType(){
        return getHead().getType();
    }
    /**
     * 执行 forEach 循环
     * @param action 动作
     */
    default void forEach(Consumer<T> action){
        getBody().forEach(action);
    }

    /**
     * 获取 Stream流
     * @return Stream流
     */
    default Stream<T> stream(){
        return getBody().stream();
    }

    /**
     * 获取 迭代器
     * @return 迭代器
     */
    default Iterator<T> iterator(){
        return getBody().iterator();
    }
}
