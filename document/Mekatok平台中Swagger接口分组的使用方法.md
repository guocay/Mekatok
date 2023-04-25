### 准备

```xml
<!-- 引入扩展模块 -->
<dependency>
  <groupId>icu.guokai</groupId>
  <artifactId>mekatok-framework-plugin</artifactId>
</dependency>
```

### 使用

```java
@Component
public class DiskSwaggerDocket extends SwaggerDocket {

  // 设置分组名称
  @Override
  public String title() {
    return "字典管理模块";
  }

  // 设置分组备注
  @Override
  public String description() {
    return title() + "相关接口";
  }

  // 设置模块作者
  @Override
  public String authorName() {
    return Global.GK;
  }

  // 设置版本
  @Override
  public String version() {
    return Global.APPLICATION_VERSION;
  }

	// 设置当前分组扫描的包路径
  @Override
  public String basePackage() {
    return DicModuleInfo.MODULE_ROOT_PATH;
  }

  // 设置模块名
  @Override
  public String name() {
    return DicModuleInfo.MODULE_NAME;
  }
}
```

