package mekatok.core.component.container;

/**
 * 构造器 接口
 * @author aCay
 * @since 2023.03.13
 */
public interface IBuilder<T> {

    /**
     * 构造对象
     * @return 实体
     */
    T build();
}
