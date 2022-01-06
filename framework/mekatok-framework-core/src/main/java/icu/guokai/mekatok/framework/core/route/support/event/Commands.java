package icu.guokai.mekatok.framework.core.route.support.event;

import lombok.Getter;

/**
 * 命令类型
 * @author GuoKai
 * @date 2022/1/6
 */
public enum Commands {

    /**
     * 新增
     */
    INSERT("新增"),

    /**
     * 更新
     */
    UPDATE("更新"),

    /**
     * 删除
     */
    DELETE("删除"),

    /**
     * 默认
     */
    DEFAULT("默认");

    @Getter
    private String name;

    Commands(String name){
        this.name = name;
    }

}
