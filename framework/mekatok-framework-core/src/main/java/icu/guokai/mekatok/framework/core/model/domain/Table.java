package icu.guokai.mekatok.framework.core.model.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import icu.guokai.mekatok.framework.core.constant.jsr303.VerifyGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * 平台内所有数据表映射对象的基类
 * @author GuoKai
 * @date 2021/8/5
 */
@Data
@SuppressWarnings("all")
public abstract class Table<T extends Table> extends View<T> {

    @TableId("ID")
    @ApiModelProperty(value = "数据主键")
    @NotEmpty(groups = {VerifyGroup.UPDATE.class, VerifyGroup.DELETE.class})
    private String id;

    @JsonIgnore
    @ApiModelProperty(value = "创建者",hidden = true)
    @TableField(value = "CREATOR",select = false,fill= FieldFill.INSERT)
    private String creator;

    @JsonIgnore
    @ApiModelProperty(value = "更新者",hidden = true)
    @TableField(value = "UPDATER",select = false,fill= FieldFill.INSERT_UPDATE)
    private String updater;

    @JsonIgnore
    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField(value = "CREATE_TIME",select = false,fill= FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonIgnore
    @ApiModelProperty(value = "更新时间",hidden = true)
    @TableField(value = "UPDATE_TIME",select = false,fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    @JsonIgnore
    @ApiModelProperty(value = "数据状态",hidden = true)
    @TableField(value = "DATA_STATUS",select = false,fill= FieldFill.INSERT_UPDATE)
    private String dataStatus;

    /**
     * 查询单表数据时候的缓存名称
     */
    @JsonIgnore
    @TableField(exist = false)
    @ApiModelProperty(hidden = true)
    protected String ENTITY_CACHE_NAME = cacheName() + ".Entity";

    /**
     * 获取缓存名称
     * @return 获取缓存名称
     */
    protected String cacheName(){
        return getClass().getName();
    }

    /**
     * 修改主键
     * @param id 主键
     * @return 对象
     */
    public T setId(String id) {
        this.id = id;
        return (T) this;
    }

    /**
     * 添加
     * @return 操作成功
     */
    public T insert(){
        var sqlSession = sqlSession();
        try {
            SqlHelper.retBool(sqlSession.insert(sqlStatement(SqlMethod.INSERT_ONE), this));
            saveCache();
            return (T) this;
        } finally {
            closeSqlSession(sqlSession);
        }
    }

    /**
     * 更新
     * @return 操作成功
     */
    public T update(){
        Assert.isFalse(StringUtils.checkValNull(getId()), "updateById primaryKey is null.");
        // updateById
        var map = CollectionUtils.newHashMapWithExpectedSize(1);
        map.put(Constants.ENTITY, this);
        var sqlSession = sqlSession();
        try {
            SqlHelper.retBool(sqlSession.update(sqlStatement(SqlMethod.UPDATE_BY_ID), map));
            saveCache();
            return (T) this;
        } finally {
            closeSqlSession(sqlSession);
        }
    }

    /**
     * 是否存在当前对象
     * @return 是否存在当前对象
     */
    public Boolean has(){
        Assert.isFalse(StringUtils.checkValNull(getId()), "buildById primaryKey is null.");
        var obj = detail();
        if (obj != null){
            BeanUtil.copyProperties(obj,this);
            return true;
        }
        return false;
    }

    /**
     * 保存,根据主键是否为空来判断执行添加或更新操作
     * 主键为空则新增.否则为更新.
     * @return 操作成功
     */
    public T save(){
        return StringUtils.checkValNotNull(getId()) && has() ? update() : insert();
    }

    /**
     * 刪除
     * @return 操作成功
     */
    public Boolean delete(){
        Assert.isFalse(StringUtils.checkValNull(getId()), "deleteById primaryKey is null.");
        var sqlSession = sqlSession();
        try {
            SqlHelper.retBool(sqlSession.delete(sqlStatement(SqlMethod.DELETE_BY_ID), getId()));
            deleteCache();
            return true;
        } finally {
            closeSqlSession(sqlSession);
        }
    }

    /**
     * 根据数据主键,查询数据详情.
     * @return 数据详情
     */
    public T detailByDb(){
        log.info("缓存未命中,开始查询数据库数据...");
        var id = getId();
        Assert.isFalse(StringUtils.checkValNull(id), "buildById primaryKey is null.");
        var sqlSession = this.sqlSession();
        try {
            var obj = sqlSession.selectOne(sqlStatement(SqlMethod.SELECT_BY_ID), id);
            Assert.isTrue(ObjectUtil.isNotNull(obj),"The data pointed to by the primary key is empty.");
            BeanUtil.copyProperties(obj,this);
        } finally {
            closeSqlSession(sqlSession);
        }
        return (T) this;
    }

    /**
     * 根据数据主键,查询数据详情.
     * 走缓存的那种.
     * @return 数据详情
     */
    public T detail(){
        var cache = cache();
        if(ObjectUtil.isNull(cache.get(id))){
            cache.put(id,detailByDb());
        }
        BeanUtil.copyProperties(cache.get(id).get(),this);
        return (T) this;
    }

    /**
     * 删除缓存内容
     * @return 操作成功
     */
    private boolean deleteCache(){
        return cache().evictIfPresent(id);
    }

    /**
     * 更新缓存内容
     */
    private void saveCache(){
        cache().put(id,this);
    }

    /**
     * 获取缓存对象
     * @return 缓存对象
     */
    private Cache cache(){
        return SpringUtil.getBean(CacheManager.class).getCache(ENTITY_CACHE_NAME);
    }
}
