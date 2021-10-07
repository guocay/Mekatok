package icu.guokai.mekatok.framework.core.model.domain;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import icu.guokai.mekatok.framework.core.model.dto.Transport;
import icu.guokai.mekatok.framework.core.page.PageUtil;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 上帝的归上帝,凯撒的归凯撒
 * 抽象出这个类是为了映射视图,从而尽可能的不在项目中书写SQL.
 * @author GuoKai
 * @date 2021/8/19
 */
@SuppressWarnings("all")
public abstract class View<T extends View> implements Transport {

    /**
     * 日志对象,用于打印消息
     */
    @TableField(exist = false)
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 获取主键
     * @return 主键
     */
    public String getId() {
        return null;
    }

    /**
     * 根据条件,查询全部
     * @return 全部符合要求的数据
     */
    public List<T> selectList() {
        log.info("缓存未命中,开始查询数据库数据...");
        Map<String, Object> map = CollectionUtils.newHashMapWithExpectedSize(1);
        map.put(Constants.WRAPPER, Wrappers.query(this));
        var sqlSession = sqlSession();
        List<T> list;
        try {
            list = sqlSession.selectList(sqlStatement(SqlMethod.SELECT_LIST), map);
        } finally {
            closeSqlSession(sqlSession);
        }
        return list;
    }

    /**
     * 查询符合条件的数据总数
     * @return 总数
     */
    public Integer count() {
        Map<String, Object> map = CollectionUtils.newHashMapWithExpectedSize(1);
        map.put(Constants.WRAPPER, Wrappers.query(this));
        var sqlSession = sqlSession();
        int count;
        try {
            count = SqlHelper.retCount(sqlSession.<Integer>selectOne(sqlStatement(SqlMethod.SELECT_COUNT), map));
        } finally {
            closeSqlSession(sqlSession);
        }
        return count;
    }

    /**
     * 根据Wrapper,查询数据分页.
     * 这个函数没用
     * @return 分页数据
     */
    public IPage<T> selectPage() {
        log.info("缓存未命中,开始查询数据库数据...");
        var page = PageUtil.<T>buildPageInfo();
        var queryWrapper = Wrappers.query(this);
        Map<String, Object> map = CollectionUtils.newHashMapWithExpectedSize(2);
        map.put(Constants.WRAPPER, queryWrapper);
        map.put("page", page);
        SqlSession sqlSession = sqlSession();
        try {
            page.setRecords(sqlSession.selectList(sqlStatement(SqlMethod.SELECT_PAGE), map));
        } finally {
            closeSqlSession(sqlSession);
        }
        return page;
    }

    /**
     * 用于数据库对象装箱
     * @param clazz 装箱的类描述
     * @param <F> 装箱的类型
     * @return 装箱后的对象
     */
    public <F extends Transport> F boxing(Class<F> clazz){
        F tran = ReflectUtil.newInstance(clazz);
        // todo 循环获取当前类的字段
        Arrays.stream(ReflectUtil.getFields(getClass())).parallel()
                // todo 过滤出需要拆箱的字段
                .filter(field -> AnnotationUtil.hasAnnotation(field, Boxing.class))
                .forEach(field -> {
                    // todo 获取字段中所有 Boxing 描述信息
                    Arrays.stream(field.getAnnotationsByType(Boxing.class)).parallel()
                            // todo 过滤出需要转换的类
                            .filter(anno -> clazz.isAssignableFrom(anno.clazz()))
                            .forEach(anno -> {
                                var tranField = ReflectUtil.getField(clazz, anno.field());
                                // todo 设置字段反射,绕过权限校验
                                field.setAccessible(true);
                                tranField.setAccessible(true);
                                // todo 设置值
                                ReflectUtil.setFieldValue(tran, tranField, ReflectUtil.getFieldValue(this, field));
                            });
                });
        return tran;
    }


    /**
     * 释放sqlSession
     * @param sqlSession session
     */
    protected void closeSqlSession(SqlSession sqlSession) {
        SqlSessionUtils.closeSqlSession(sqlSession, GlobalConfigUtils.currentSessionFactory(getClass()));
    }

    /**
     * 获取SqlStatement
     * @param sqlMethod Sql方法
     */
    protected String sqlStatement(SqlMethod sqlMethod) {
        //无法确定对应的mapper，只能用注入时候绑定的了。
        return SqlHelper.table(this.getClass()).getSqlStatement(sqlMethod.getMethod());
    }

    /**
     * 获取Session 默认自动提交
     */
    protected SqlSession sqlSession() {
        return SqlHelper.sqlSession(this.getClass());
    }
}
