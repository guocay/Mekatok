package com.github.guokaia.mekatok.core.enums;

/**
 * 值类型枚举基类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/15
 */
public interface ValueEnum<V> {

    /**
     * 获取值
     * @return 值
     */
    V getValue();

}
