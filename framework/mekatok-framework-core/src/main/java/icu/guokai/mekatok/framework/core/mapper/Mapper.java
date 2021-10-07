package icu.guokai.mekatok.framework.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.guokai.mekatok.framework.core.model.domain.View;

import java.util.Optional;

/**
 * 项目中所有Mapper的基类
 * @author GuoKai
 * @date 2021/8/5
 */
public interface Mapper<T extends View> extends BaseMapper<T> {

    /**
     * 判断当前主键是否存在
     * @param id 主键
     * @return 是否存在
     */
    default Boolean hasThat(String id){
        return selectById(id) != null;
    }

    /**
     * 查询符合条件的第一个对象
     * @param wrapper 查询条件
     * @return 符合条件的第一个对象
     */
    default Optional<T> findFirst(Wrapper<T> wrapper){
       return selectList(wrapper).stream().findFirst();
    }

}
