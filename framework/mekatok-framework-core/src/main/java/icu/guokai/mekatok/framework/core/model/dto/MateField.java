package icu.guokai.mekatok.framework.core.model.dto;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * 用于存储数据传输对象与数据库对象之间的关联关系
 * @author GuoKai
 * @date 2021/9/28
 */
@Data(staticConstructor = "of")
public class MateField {

    /**
     * 待拷贝的字段
     */
    private Field from;

    /**
     * 拷贝到的字段
     */
    private Field to;

}
