package icu.guokai.mekatok.framework.flowable.configure;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.flowable.engine.*;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 自定义配置Flowable
 * @author GuoKai
 * @date 2021/8/30
 */
@Configuration
@SuppressWarnings("all")
public class FlowableConfiguration {

    /**
     * 流程使用默认数据库
     */
    private static final String DB_NAME = "flowable";

    public DataSourceTransactionManager dataSourceTransactionManager(){
        var manager = new DataSourceTransactionManager();
        manager.setDataSource(getFlowableDb());
        return manager;
    }

    /**
     * 创建引擎的配置对象
     * @return
     */
    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(){
        var conf = new SpringProcessEngineConfiguration();
        conf.setDatabaseSchemaUpdate("true");
        conf.setAsyncExecutorActivate(false);
        conf.setDataSource(getFlowableDb());
        conf.setTransactionManager(dataSourceTransactionManager());
        // todo 自动部署资源
        // conf.setDeploymentResources();
        return conf;
    }

    /**
     * 创建引擎工厂
     * @return
     */
    @Bean
    public ProcessEngineFactoryBean ProcessEngineFactoryBean(){
        var factory = new ProcessEngineFactoryBean();
        factory.setProcessEngineConfiguration(springProcessEngineConfiguration());
        return factory;
    }

    /**
     * RepositoryService
     * @return
     * @throws Exception 获取异常
     */
    @Bean
    public RepositoryService repositoryService() throws Exception {
        return ProcessEngineFactoryBean().getObject().getRepositoryService();
    }

    /**
     * RepositoryService
     * @return
     * @throws Exception 获取异常
     */
    @Bean
    public RuntimeService runtimeService() throws Exception {
        return ProcessEngineFactoryBean().getObject().getRuntimeService();
    }

    /**
     * TaskService
     * @return
     * @throws Exception 获取异常
     */
    @Bean
    public TaskService taskService() throws Exception {
        return ProcessEngineFactoryBean().getObject().getTaskService();
    }

    /**
     * HistoryService
     * @return
     * @throws Exception 获取异常
     */
    @Bean
    public HistoryService historyService() throws Exception {
        return ProcessEngineFactoryBean().getObject().getHistoryService();
    }

    /**
     * ManagementService
     * @return
     * @throws Exception 获取异常
     */
    @Bean
    public ManagementService managementService() throws Exception {
        return ProcessEngineFactoryBean().getObject().getManagementService();
    }

    /**
     * 获取使用的数据源
     * 这个函数 仅仅适用于在 dynamic-datasource-spring-boot-starter 中
     * 获取数据源
     * @return
     */
    private DataSource getFlowableDb(){
        return ReflectUtil.<DataSource>invoke(SpringUtil.getBean(DataSource.class),"getDataSource",DB_NAME);
    }

}
