package icu.guokai.mekatok.framework.flowable;

import cn.hutool.extra.spring.SpringUtil;
import org.flowable.engine.*;
import org.flowable.spring.ProcessEngineFactoryBean;

/**
 * 工作流引擎 工具类
 * @author GuoKai
 * @date 2021/8/30
 */
public abstract class FlowableCenter {

    /**
     * RepositoryService
     * @return RepositoryService
     */
    public static RepositoryService repositoryService(){
        return SpringUtil.getBean(RepositoryService.class);
    }

    /**
     * RuntimeService
     * @return RuntimeService
     */
    public static RuntimeService runtimeService(){
        return SpringUtil.getBean(RuntimeService.class);
    }

    /**
     * TaskService
     * @return TaskService
     */
    public static TaskService taskService(){
        return SpringUtil.getBean(TaskService.class);
    }

    /**
     * HistoryService
     * @return HistoryService
     */
    public static HistoryService historyService(){
        return SpringUtil.getBean(HistoryService.class);
    }

    /**
     * ManagementService
     * @return ManagementService
     */
    public static ManagementService managementService(){
        return SpringUtil.getBean(ManagementService.class);
    }

    /**
     * ProcessEngineFactoryBean
     * @return ProcessEngineFactoryBean
     */
    public static ProcessEngineFactoryBean processEngineFactoryBean(){
        return SpringUtil.getBean(ProcessEngineFactoryBean.class);
    }

}
