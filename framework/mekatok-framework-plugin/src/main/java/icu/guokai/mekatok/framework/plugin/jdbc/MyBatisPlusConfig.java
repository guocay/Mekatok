package icu.guokai.mekatok.framework.plugin.jdbc;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.security.SecurityCenter;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * MybatisPlus插件配置页面
 * @author GuoKai
 * @date 2021/8/13
 */
@Configuration
@SuppressWarnings("all")
@EnableTransactionManagement
@MapperScan(basePackages = Global.BASIC_PACKAGE_NAME+".**.mapper")
public class MyBatisPlusConfig implements MetaObjectHandler {

    /**
     * 默认用户主键
     */
    private static final String DEFAULT_USER_ID = "NO_RECORD";

    /**
     * 雪花算法
     */
    private final Snowflake SNOW_FLAKE = new Snowflake(Global.WORKER_ID,Global.DATA_CENTER_ID);


    @Override
    public void insertFill(MetaObject metaObject) {
        var timestamp = LocalDateTime.now();
        var id = Optional.ofNullable(SecurityCenter.getUserId()).orElse(DEFAULT_USER_ID);
        this.strictInsertFill(metaObject,"creator",String.class,id);
        this.strictInsertFill(metaObject,"updater",String.class,id);
        this.strictInsertFill(metaObject,"createTime",LocalDateTime.class,timestamp);
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class,timestamp);
        this.strictInsertFill(metaObject,"dataStatus",String.class,Global.EFFECTIVE_STATUS);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updater",String.class,
                Optional.ofNullable(SecurityCenter.getUserId()).orElse(DEFAULT_USER_ID));
        this.strictUpdateFill(metaObject,"updateTime",LocalDateTime.class,LocalDateTime.now());
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInnerInterceptor paginationInterceptor(){
        var interceptor = new PaginationInnerInterceptor();
        //设置请求的数据大于最大页后的操作,true返回到首页
        interceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条,-1 不受限制
        interceptor.setMaxLimit(500L);
        return interceptor;
    }

    /**
     * MybatisPlus 扩展插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        var mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(paginationInterceptor());
        return mybatisPlusInterceptor;
    }

    /**
     * 雪花算法,用于生成主键.
     * @return Mybatis Plus Id生成器
     */
    @Bean
    public IdentifierGenerator customIdGenerator(){
        return (entity) -> SNOW_FLAKE.nextId();
    }
}
