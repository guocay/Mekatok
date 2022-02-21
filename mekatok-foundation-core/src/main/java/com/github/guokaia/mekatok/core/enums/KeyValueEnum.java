package com.github.guokaia.mekatok.core.enums;

/**
 * 键值值类型枚举基类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/15
 */
public interface KeyValueEnum<K,V> extends ValueEnum<V> {

    /**
     * 获取键
     * @return 键
     */
    K getKey();

}
