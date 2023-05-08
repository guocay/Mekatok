package mekatok.infrastructure.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * mybatis plus 的元数据管理器
 * @author GuoCay
 * @since 2023.03.09
 */
public class CustomMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        long nowTime = System.currentTimeMillis();
        // 设置数据的创建时间,更新时间及数据有效性.
        this.strictInsertFill(metaObject,"createTime", Long.class,nowTime);
        this.strictInsertFill(metaObject,"updateTime", Long.class,nowTime);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        long nowTime = System.currentTimeMillis();
        this.strictInsertFill(metaObject,"updateTime", Long.class,nowTime);
    }
}
