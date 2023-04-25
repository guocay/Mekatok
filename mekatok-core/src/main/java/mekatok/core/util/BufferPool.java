package mekatok.core.util;

/**
 * 缓存池
 * @author aCay
 * @since 2023.04.04
 */
public interface BufferPool<KEY, VALUE>{

    VALUE get(KEY key);

    VALUE get(KEY key, VALUE defaultValue);

    boolean exists(KEY key);

    // 添加

    // 添加当不存在

    // 比较并添加

    // 获取并删除

    // 删除

    // 是否包含 key

    // 是否包含 value

    // 获取所有值

    // 替换所有值

}
