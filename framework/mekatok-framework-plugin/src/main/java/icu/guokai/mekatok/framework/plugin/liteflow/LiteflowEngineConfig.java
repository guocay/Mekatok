package icu.guokai.mekatok.framework.plugin.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.monitor.MonitorBus;
import com.yomahub.liteflow.property.LiteflowConfig;
import com.yomahub.liteflow.spring.ComponentScanner;
import com.yomahub.liteflow.util.SpringAware;
import icu.guokai.mekatok.framework.plugin.liteflow.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于配置流程编排工具 LiteFlow
 * @author GuoKai
 * @date 2021/10/30
 */
@Configuration
@SuppressWarnings("all")
public class LiteflowEngineConfig {

    @Autowired
    private Property property;

    /**
     * 配置基于代码形式的spring上下文工具类
     * @return SpringAware
     */
    @Bean
    public SpringAware SpringAware(){
        return new SpringAware();
    }

    /**
     * 组件扫描类
     * @return
     */
    @Bean
    public ComponentScanner componentScaner(){
        return new ComponentScanner();
    }

    /**
     * 配置 LiteFlow 的全局配置
     * @return LiteflowConfig
     */
    @Bean
    public LiteflowConfig liteflowConfig(){
        var liteflow = new LiteflowConfig();
        // 流程文件路径
        liteflow.setRuleSource(property.getRuleSources());
        // 异步线程池最大线程数
        liteflow.setWhenMaxWorkers(10);
        // 开启日志
        liteflow.setEnableLog(true);
        // 允许多种配置格式(xml,json,yaml),同时存在.
        liteflow.setSupportMultipleType(true);
        return liteflow;
    }

    /**
     * 配置 LiteFlow 执行器
     * @return FlowExecutor
     */
    @Bean
    public FlowExecutor flowExecutor(LiteflowConfig config){
        var executor = new FlowExecutor();
        executor.setLiteflowConfig(config);
        executor.reloadRule();
        return executor;
    }

    /**
     * 配置 LiteFlow 流程监控
     * @return MonitorBus
     */
    @Bean
    public MonitorBus monitorBus(LiteflowConfig config){
        return new MonitorBus(config);
    }

}
