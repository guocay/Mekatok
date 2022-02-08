package com.github.guokaia.mekatok.jdbc.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.github.guokaia.mekatok.core.model.store.Table;
import com.github.guokaia.mekatok.core.model.store.View;
import com.github.guokaia.mekatok.jdbc.page.PagingHolder;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 全局Mapper对象
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
@SuppressWarnings("all")
public class MapperHolder {

    private MapperHolder(){}

    /**
     * 保存<br/>
     * 判断是否有主键并且数据库中不存在就调用更新, 否则调用新增.
     * @param domain 更新前对象
     * @param <T> 泛型
     * @return 更新后对象
     */
    public static <T extends Table<T>> T save(T domain){
        if (StringUtils.checkValNotNull(domain.getId()) && has(domain)){
            update(domain);
            return get(domain);
        }else {
            return insert(domain);
        }
    }

    /**
     * 查询当前对象是否存在于数据库, 根据ID.
     * @param domain 查询对象
     * @param <T> 泛型
     * @return 是否存在
     */
    public static <T extends Table<T>> Boolean has(T domain){
        Boolean has = Objects.nonNull(domain.getId());
        if(has){
            has = Objects.nonNull(domain = get(domain));
        }
        return has;
    }

    /**
     * 保存
     * @param domain 保存前对象
     * @param <T> 泛型
     * @return 持久化对象
     */
    public static <T extends Table<T>> T insert(T domain){
        Class clazz = domain.getClass();
        String sqlStatement = SqlHelper.table(clazz).getSqlStatement(SqlMethod.INSERT_ONE.getMethod());
        SqlSession seesion = SqlHelper.sqlSession(clazz);
        seesion.insert(sqlStatement, domain);
        SqlSessionUtils.closeSqlSession(seesion, GlobalConfigUtils.currentSessionFactory(clazz));
        return domain;
    }

    /**
     * 更新
     * @param domain 更新前对象
     * @param <T> 泛型
     * @return 更新后对象
     */
    public static <T extends Table<T>> Integer update(T domain){
        Assert.isFalse(StringUtils.checkValNull(domain.getId()), "updateById primaryKey is null.");
        Class clazz = domain.getClass();
        Map<Object, Object> map = CollectionUtils.newHashMapWithExpectedSize(1);
        map.put(Constants.ENTITY, domain);
        String sqlStatement = SqlHelper.table(clazz).getSqlStatement(SqlMethod.UPDATE_BY_ID.getMethod());
        SqlSession seesion = SqlHelper.sqlSession(clazz);
        Integer row = seesion.update(sqlStatement, map);
        SqlSessionUtils.closeSqlSession(seesion, GlobalConfigUtils.currentSessionFactory(clazz));
        return row;
    }

    /**
     * 查询数据从数据库
     * @param domain 查询对象
     * @param <T> 泛型
     * @return 查询后对象
     */
    public static <T extends Table<T>> T get(T domain){
        Assert.isFalse(StringUtils.checkValNull(domain.getId()), "buildById primaryKey is null.");
        Class clazz = domain.getClass();
        String sqlStatement = SqlHelper.table(clazz).getSqlStatement(SqlMethod.SELECT_BY_ID.getMethod());
        SqlSession seesion = SqlHelper.sqlSession(clazz);
        domain = seesion.selectOne(sqlStatement, domain.getId());
        SqlSessionUtils.closeSqlSession(seesion, GlobalConfigUtils.currentSessionFactory(clazz));
        return domain;
    }

    /**
     * 删除
     * @param domain 查询对象
     * @param <T> 泛型
     * @return 删除是否成功
     */
    public static <T extends Table<T>> Integer delete(T domain){
        Assert.isFalse(StringUtils.checkValNull(domain.getId()),"deleteById primaryKey is null.");
        Class clazz = domain.getClass();
        String sqlStatement = SqlHelper.table(clazz).getSqlStatement(SqlMethod.DELETE_BY_ID.getMethod());
        SqlSession seesion = SqlHelper.sqlSession(clazz);
        Integer row = seesion.delete(sqlStatement, domain);
        SqlSessionUtils.closeSqlSession(seesion, GlobalConfigUtils.currentSessionFactory(clazz));
        return row;
    }

    /**
     * 拼接对象属性后,作为查询条件查询数据.
     * @param domain 查询对象
     * @param <T> 泛型
     * @return 查询后对象
     */
    public static <T extends View<T>> List<T> list(T domain){
        Class clazz = domain.getClass();
        Map<String, Object> map = CollectionUtils.newHashMapWithExpectedSize(1);
        map.put(Constants.WRAPPER, Wrappers.query(domain));
        String sqlStatement = SqlHelper.table(clazz).getSqlStatement(SqlMethod.SELECT_LIST.getMethod());
        SqlSession seesion = SqlHelper.sqlSession(clazz);
        List<T> list = seesion.selectList(sqlStatement, map);
        SqlSessionUtils.closeSqlSession(seesion, GlobalConfigUtils.currentSessionFactory(clazz));
        return list;
    }

    /**
     * 分页查询, 使用这个的时候需要注意必须在请求线程中.因为默认是从当前线程中取header里的分页信息.
     * @param domain 查询对象
     * @param <T> 泛型
     * @return 分页信息
     */
    public static <T extends View<T>> IPage<T> page(T domain){
        return page(domain, PagingHolder.page());
    }

    /**
     * 分页查询
     * @param domain 查询对象
     * @param page 分页对象
     * @param <T> 泛型
     * @return 分页信息
     */
    public static <T extends View<T>> IPage<T> page(T domain, IPage<T> page){
        Class clazz = domain.getClass();
        QueryWrapper queryWrapper = Wrappers.query(domain);
        Map<String, Object> map = CollectionUtils.newHashMapWithExpectedSize(2);
        map.put(Constants.WRAPPER, queryWrapper);
        map.put("page", page);
        SqlSession seesion = SqlHelper.sqlSession(clazz);
        String sqlStatement = SqlHelper.table(clazz).getSqlStatement(SqlMethod.SELECT_PAGE.getMethod());
        page.setRecords(seesion.selectList(sqlStatement, map));
        // 如果不分页, 将记录的条数赋值给总条数.
        if(page.getSize() == -1){
            page.setTotal(page.getRecords().size());
        }
        SqlSessionUtils.closeSqlSession(seesion, GlobalConfigUtils.currentSessionFactory(clazz));
        return page;
    }

}

