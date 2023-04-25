package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * 基于Table对象的断言工具
 * @author GuoKai
 * @date 2021/10/7
 */
public class TableAssert<T extends Table<?>> extends Assert<TableAssert<T>, T> {
    /**
     * 构造器
     * @param actual 待断言对象
     */
    public TableAssert(T actual) {
        super(actual);
    }

    @Override
    public TableAssert<T> is(T obj) {
        return exception(actual.equals(obj));
    }

    /**
     * 创建人
     * @param obj 创建人ID
     * @return 断言工具
     */
    public TableAssert<T> creator(@NonNull String obj){
        return exception(obj.equals(actual.getCreator()));
    }

    /**
     * 创建时间
     * @param obj 创建时间
     * @return 断言工具
     */
    public TableAssert<T> createTime(@NonNull LocalDateTime obj){
        return exception(obj.equals(actual.getCreateTime()));
    }

    /**
     * 更新人
     * @param obj 更新人ID
     * @return 断言工具
     */
    public TableAssert<T> updater(@NonNull String obj){
        return exception(obj.equals(actual.getUpdater()));
    }

    /**
     * 更新时间
     * @param obj 更新时间
     * @return 断言工具
     */
    public TableAssert<T> updateTime(@NonNull LocalDateTime obj){
        return exception(obj.equals(actual.getUpdateTime()));
    }

    /**
     * 有效数据
     * @return 断言工具
     */
    public TableAssert<T> isEffective(){
        return exception(Global.EFFECTIVE_STATUS.equals(actual.getDataStatus()));
    }
    /**
     * 无效数据
     * @return 断言工具
     */
    public TableAssert<T> isInvalid(){
        return exception(Global.INVALID_STATUS.equals(actual.getDataStatus()));
    }

    /**
     * 主键
     * @param obj 主键
     * @return 断言工具
     */
    public TableAssert<T> id(@NonNull String obj){
        return exception(obj.equals(actual.getId()));
    }

    /**
     * 有主键
     * @return 断言工具
     */
    public TableAssert<T> hasId(){
        return exception(StrUtil.isNotBlank(actual.getId()));
    }


    /**
     * 没有主键
     * @return 断言工具
     */
    public TableAssert<T> notHasId(){
        return exception(StrUtil.isBlank(actual.getId()));
    }

    /**
     * 属性值
     * @param key 属性名
     * @param value 属性值
     * @return 断言工具
     */
    public TableAssert<T> attributes(String key, Object value) {
        try {
            exception(value.equals(ReflectUtil.getFieldValue(actual, key)));
        }catch (Throwable throwable){
            exception();
        }
        return self();
    }
}
