package com.github.guokaia.mekatok.core.model;

import java.util.Collection;

/**
 * 传输对象中的分页载体
 * @author GuoKai
 * @date 2022/1/27
 */
public interface Paging<T extends Packing<T>> extends Container<T> {

    /**
     * 获取分页列表
     * @return 分页的列表
     */
    Collection<T> getRecords();

    /**
     * 获取总条数
     * @return 总条数
     */
    Long getTotal();

    /**
     * 获取每页显示的条数
     * @return 每页数量
     */
    Long getSize();

    /**
     * 获取当前页页号
     * @return 页号
     */
    Long getCurrent();

    /**
     * 获取记录中的第一个元素
     * @return 第一个元素
     */
    default T findFirst(){
        return getRecords().stream().findFirst().orElse(null);
    }
}
