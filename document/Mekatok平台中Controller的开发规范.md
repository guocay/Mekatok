### 准备

```xml
<!-- 引入核心模块 -->
<dependency>
  <groupId>icu.guokai</groupId>
  <artifactId>mekatok-framework-core</artifactId>
</dependency>
```

### 使用

```java
import icu.guokai.mekatok.framework.core.route.support.SimpleCrudSupport;
import icu.guokai.mekatok.framework.core.route.Router;

@RestController
@Api(tags = "用户相关接口")
@ApiSupport(author = Global.GK)
@RequestMapping(OuModuleInfo.MODULE_ROUTE_URI + "/user")
public class UserRouter extends Router implements SimpleCrudSupport<User>{
  
}
```

### 讲解

```java
// icu.guokai.mekatok.framework.core.route.Router中现阶段提供了一个log属性用于打印日志,可在UserRouter中直接使用
import org.slf4j.Logger;
protected Logger log = LoggerFactory.getLogger(getClass());

// icu.guokai.mekatok.framework.core.route.support.SimpleCrudSupport<T>中提供了默认的增删改查功能,通过泛型指定代理的数据表.

// SimpleCrudSupport继承了四个接口,分别是
// SimpleCreateSupport 增加相关接口
@PostMapping
default ResponseEntity<Boolean> insert(@Validated(VerifyGroup.ADD.class) T bean);

// SimpleDeleteSupport 删除相关接口
@DeleteMapping("/{id}")
default ResponseEntity<Boolean> delete(@PathVariable("id") String id);

// SimpleRetrieveSupport 查询相关接口
@GetMapping("/{id}")
default ResponseEntity<T> get(@PathVariable("id") String id);
@GetMapping("/page")
default ResponseEntity<List<T>> page(@Validated(VerifyGroup.QUERY.class) T bean);

// SimpleUpdateSupport 更新相关接口
@PutMapping
default ResponseEntity<Boolean> update(@Validated(VerifyGroup.UPDATE.class) T bean);

// 实际操作过程中,如遇不需暴露crud某一功能的数据表,可直接实现上述四个接口的其中几个.
```

