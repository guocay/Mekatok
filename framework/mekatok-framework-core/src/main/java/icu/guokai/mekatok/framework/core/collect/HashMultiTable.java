package icu.guokai.mekatok.framework.core.collect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 基于hashmap实现的Table
 * @author GuoKai
 * @date 2021/10/8
 */
public class HashMultiTable<R,C,V> extends HashMap<R,HashMap<C,V>> implements MultiTable<R,C,V> {

    private static final long serialVersionUID = -9159611088510187396L;

    /**
     * 检查是否存在当前行
     * @param row 行
     * @return 行数据
     */
    private Map<C, V> check(R row){
        return Optional.ofNullable(get(row)).orElse(put(row, new HashMap<C,V>(16)));
    }

    @Override
    public V add(R row, C column,V value) {
        return check(row).put(column,value);
    }

    @Override
    public V getValue(R row, C column) {
        var rows = get(row);
        if(rows == null){
            return null;
        }
        return rows.get(column);
    }

    @Override
    public void delete(R row, C column) {
        var rows = get(row);
        if(rows != null){
            rows.remove(column);
        }
    }

    @Override
    public Map<C, V> row(R row) {
        return get(row);
    }

    @Override
    public List<V> allValues() {
        return values().parallelStream().flatMap(item -> item.values().parallelStream()).collect(Collectors.toList());
    }

    @Override
    public long allSize() {
        return values().parallelStream().flatMap(item -> item.values().parallelStream()).count();
    }

    @Override
    public Set<R> rowKeySet() {
        return keySet();
    }

    @Override
    public boolean containsRow(R rowKey) {
        return containsKey(rowKey);
    }

    @Override
    public boolean contains(R rowKey, C columnKey) {
        var row = get(rowKey);
        return row != null && row.get(columnKey) != null;
    }

    @Override
    public boolean contains(V value) {
        return values().parallelStream().anyMatch(item -> item.containsValue(value));
    }

    @Override
    public boolean containsColumn(C columnKey) {
        return values().parallelStream().anyMatch(item -> item.containsKey(columnKey));
    }

    @Override
    public Map<R, V> column(C column) {
        return keySet().parallelStream().filter(this::containsKey).collect(Collectors.toMap(key -> key, key -> get(key).get(column)));
    }

    @Override
    public Set<C> columnKeySet() {
        return values().parallelStream().flatMap(item -> item.keySet().parallelStream()).collect(Collectors.toSet());
    }

}
