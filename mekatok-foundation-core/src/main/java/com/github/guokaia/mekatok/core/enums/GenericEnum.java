package com.github.guokaia.mekatok.core.enums;

/**
 * 通用键值值类型枚举基类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/15
 */
public enum GenericEnum implements KeyValueEnum<Object, Object>{

    ;

    private final Object key;

    private final Object value;

    GenericEnum(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }

}
