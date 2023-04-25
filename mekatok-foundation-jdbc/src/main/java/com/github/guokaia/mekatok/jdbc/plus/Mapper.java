package com.github.guokaia.mekatok.jdbc.plus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.guokaia.mekatok.core.model.store.View;

import java.util.Objects;

/**
 * 项目中所有Mapper的基类
 * @author GuoKai
 * @date 2022/2/2
 */
public interface Mapper<T extends View<T>> extends BaseMapper<T> {

    /**
     * 判断当前主键是否存在
     * @param id 主键
     * @return 是否存在
     */
    default Boolean hasThat(String id){
        return Objects.nonNull(selectById(id));
    }
}
