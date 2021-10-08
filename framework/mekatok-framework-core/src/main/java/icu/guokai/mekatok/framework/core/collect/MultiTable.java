package icu.guokai.mekatok.framework.core.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 一个用于描述矩阵集合数据
 * 有点类似于二维数组
 * @author GuoKai
 * @date 2021/10/8
 */
public interface MultiTable<R, C, V> {

    /**
     * 放入
     * @param row 行
     * @param column 列
     * @param value 值
     * @return 值
     */
    V add(R row,C column,V value);

    /**
     * 获取
     * @param row 行
     * @param column 列
     * @return 值
     */
    V getValue(R row,C column);

    /**
     * 删除
     * @param row 行
     * @param column 列
     */
    void delete(R row,C column);

    /**
     * 获取列
     * @param column 列
     * @return 值
     */
    Map<R,V> column(C column);

    /**
     * 获取行
     * @param row 行
     * @return 值
     */
    Map<C,V> row(R row);

    /**
     * 获取所有的值
     * @return 值
     */
    List<V> allValues();

    /**
     * 获取所有元素个数
     * @return 元素个数
     */
    long allSize();

    /**
     * 获取行集合
     * @return 行集合
     */
    Set<R> rowKeySet();

    /**
     * 获取列集合
     * @return 列集合
     */
    Set<C> columnKeySet();

    /**
     * 包含行列
     * @param rowKey 行
     * @param columnKey 列
     * @return 是否包含
     */
    boolean contains(R rowKey, C columnKey);

    /**
     * 包含列
     * @param columnKey 列
     * @return 是否包含
     */
    boolean containsColumn(C columnKey);

    /**
     * 包含行
     * @param rowKey 行
     * @return 是否包含
     */
    boolean containsRow(R rowKey);

    /**
     * 包含值
     * @param value 值
     * @return 是否包含
     */
    boolean contains(V value);

}
