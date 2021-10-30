package icu.guokai.mekatok.framework.core.service;

import cn.hutool.core.util.ReflectUtil;
import icu.guokai.mekatok.framework.core.asserts.WithAssertions;
import icu.guokai.mekatok.framework.core.liteflow.Plugin;
import icu.guokai.mekatok.framework.core.liteflow.WithLiteFlow;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 平台内用于服务实现部分的基类
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("all")
public abstract class ServiceImpl extends Plugin implements WithAssertions, WithLiteFlow {

    /**
     * 日志对象,用于打印消息
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 根据类名和主键,获取完整的对象内容.
     * 数据库记录为空时,返回仅包含传入主键的对象.
     * @param clazz 目标类名
     * @param id 主键
     * @param <T> Class 泛型
     * @return 对象内容
     */
    protected <T extends Table<?>> T pull(Class<T> clazz, String id){
        return (T) create(clazz, id).detail();
    }

    /**
     * 删除数据操作对象
     * @param clazz 对象的类型
     * @param id 对象的主键
     * @param <T> 对象的类型
     * @return success
     */
    protected <T extends Table<?>> Boolean delete(Class<T> clazz, String id){
        return create(clazz,id).delete();
    }

    /**
     * 创建实例
     * @param clazz class对象
     * @param objs 构造器参数
     * @param <T> 泛型
     * @return 实例
     */
    protected <T> T of(Class<T> clazz,Object... objs){
        if(objs.length > 0){
            return ReflectUtil.newInstance(clazz,objs);
        } else {
            return ReflectUtil.newInstance(clazz);
        }
    }

    /**
     * 根据类的全限定名,计算hashcode
     * @return hash code
     */
    @Override
    public int hashCode() {
        return getClass().getName().hashCode();
    }

    //-------------------------------------------Private Method---------------------------------------------------------
    /**
     * 构建 数据 对象
     * @param clazz 目标类名
     * @param id 主键
     * @param <T> Class 泛型
     * @return 对象内容
     */
    @SuppressWarnings("unchecked")
    private <T extends Table> T create(Class<T> clazz, String id){
        return (T) of(clazz).setId(id);
    }

    /**
     * process 默认实现
     * @throws Exception
     */
    @Override
    public void process() throws Exception {}
}
