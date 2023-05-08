package mekatok.infrastructure.impl;

import mekatok.core.gateway.Gateway;

import java.io.Serializable;
import java.util.List;

/**
 * 抽象的基础设施层路由实现
 * @author GuoCay
 * @since 2023/3/6
 */
public abstract class AbstractGateway<T> implements Gateway<T> {

    abstract int insert(T entity);

    abstract int updateById(T entity);

    abstract int deleteById(Serializable id);

    abstract List<T> select(T entity);
}
