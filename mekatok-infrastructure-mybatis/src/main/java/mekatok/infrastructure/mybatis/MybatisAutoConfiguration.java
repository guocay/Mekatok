package mekatok.infrastructure.mybatis;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置与 Mybatis 相关的设置
 * @author aCay
 * @since 2023.03.09
 */
@Configuration(proxyBeanMethods = false)
@Import(CustomMetaObjectHandler.class)
public class MybatisAutoConfiguration {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInnerInterceptor paginationInterceptor(){
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        //设置请求的数据大于最大页后的操作,true返回到首页
        interceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条,-1 不受限制. 建议不设置,因为设置-1后,分页都会走-1
        interceptor.setMaxLimit(1000L);
        return interceptor;
    }

    /**
     * 防全表更新,删除插件
     */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor(){
        return new BlockAttackInnerInterceptor();
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
}
