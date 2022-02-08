package com.github.guokaia.mekatok.jdbc;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.guokaia.mekatok.jdbc.page.PageProperties;
import com.github.guokaia.mekatok.jdbc.page.PagingHolder;
import com.github.guokaia.mekatok.webmvc.whoami.MyselfHolder;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Mybatis Plus 配置信息
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@SuppressWarnings("all")
@EnableTransactionManagement
@Import({PagingHolder.class})
@MapperScan(basePackages = "**.service.mapper")
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({PageProperties.class})
public class MybatisPlusAutoConfiguration implements MetaObjectHandler, BeanPostProcessor {

    /**
     * 默认用户主键
     */
    private static final String DEFAULT_USER_ID = "NO_RECORD";

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime timestamp = LocalDateTime.now();
        String id = Optional.ofNullable(MyselfHolder.get()).orElse(DEFAULT_USER_ID);
        this.strictInsertFill(metaObject,"creator",String.class,id);
        this.strictInsertFill(metaObject,"updater",String.class,id);
        this.strictInsertFill(metaObject,"createTime",LocalDateTime.class,timestamp);
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class,timestamp);
        this.strictInsertFill(metaObject,"dataStatus",Boolean.class, Boolean.TRUE);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updater",String.class,
            Optional.ofNullable(MyselfHolder.get()).orElse(DEFAULT_USER_ID));
        this.strictUpdateFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInnerInterceptor paginationInterceptor(){
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        //设置请求的数据大于最大页后的操作,true返回到首页
        interceptor.setOverflow(true);
        // todo 设置最大单页限制数量，默认 500 条,-1 不受限制. 建议不设置,因为设置-1后,分页都会走-1
        // interceptor.setMaxLimit(5000L);
        return interceptor;
    }

    /**
     * 防全表更新,删除插件
     */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor(){
        BlockAttackInnerInterceptor interceptor = new BlockAttackInnerInterceptor();
        return interceptor;
    }

    /**
     * MybatisPlus 扩展插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(PaginationInnerInterceptor paginationInterceptor,
                                                         BlockAttackInnerInterceptor blockAttackInnerInterceptor){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(paginationInterceptor);
        mybatisPlusInterceptor.addInnerInterceptor(blockAttackInnerInterceptor);
        return mybatisPlusInterceptor;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        /*
            使用BeanPostProcess拦截 mybatis plus 的配置项, 修改不打印 Banner.
         */
        if(bean instanceof MybatisPlusProperties){
            MybatisPlusProperties properties = (MybatisPlusProperties) bean;
            properties.getGlobalConfig().setBanner(false)
                .getDbConfig().setLogicDeleteValue("false").setLogicNotDeleteValue("true");
        }
        return bean;
    }
}
