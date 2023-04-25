package mekatok.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import mekatok.infrastructure.mo.AbstractRdbMappedObject;

import java.io.Serializable;
import java.util.Optional;

/**
 * 用于包装 Mybatis Plus中的Mapper接口
 * @author aCay
 * @since 2023.03.20
 */
public interface CrudRepository<T extends AbstractRdbMappedObject> extends BaseMapper<T> {

    /**
     * 根据主键 查找实体
     * @param id 主键
     * @return 对象
     */
    default Optional<T> findById(Serializable id){
        return Optional.ofNullable(selectById(id));
    }

    /**
     * 查找 一条数据, 结果多条时会报错.
     * @param queryWrapper 查询条件
     * @return 实体
     */
    default Optional<T> findOne(Wrapper<T> queryWrapper){
        return Optional.ofNullable(selectOne(queryWrapper));
    }

    /**
     * 保存, 根据是否有主键来判断是新增还是更新
     * @param t 实体
     * @return 影响行数
     */
    default int save(T t){
        return null == t.getId() ? insert(t) : updateById(t);
    }

    /**
     * 查询当前主键是否存在于数据库
     * @param id 主键
     * @return 是否存在
     */
    default boolean existsById(Serializable id){
        return exists(Wrappers.<T>lambdaQuery().eq(AbstractRdbMappedObject::getId, id));
    }



}
