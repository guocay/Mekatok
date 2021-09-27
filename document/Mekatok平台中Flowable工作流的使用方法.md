### 准备

```xml
<!-- 引入flowable -->
<dependency>
  <groupId>icu.guokai</groupId>
  <artifactId>mekatok-framework-flowable</artifactId>
</dependency>
```

```yaml
# 定义专供工作流使用的数据源,DataSourceName必须为"flowable".
spring:
  datasource:
    dynamic:
      datasource:
        flowable:
          driver-class-name: org.postgresql.Driver
          url: jdbc:postgresql://127.0.0.1:5432/flowable?useSSL=false
          username: guokai
          password: 123456
```

### 使用

```java
import icu.guokai.mekatok.framework.flowable.FlowableCenter;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ManagementService;
import org.flowable.spring.ProcessEngineFactoryBean;

RepositoryService service = FlowableCenter.repositoryService();
RuntimeService service = FlowableCenter.runtimeService();
TaskService service = FlowableCenter.taskService();
HistoryService service = FlowableCenter.historyService();
ManagementService service = FlowableCenter.managementService();
ProcessEngineFactoryBean service = FlowableCenter.processEngineFactoryBean();
```

