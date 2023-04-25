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
import icu.guokai.mekatok.framework.core.service.IService;
// IService 定义
// 现阶段IService接口是一个空的接口.
public interface IUserService extends IService {}
```

```java
import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import org.slf4j.Logger;

// ServiceImpl 定义
// ServiceImpl基类定义了一些公用属性和函数.
protected Logger log = LoggerFactory.getLogger(getClass()); // 日志打印
protected <T extends Table<?>> T pull(Class<T> clazz, String id); // 根据类名和主键,获取完整的对象内容.
protected <T extends Table<?>> Boolean delete(Class<T> clazz, String id); // 删除数据对象
protected <T> T of(Class<T> clazz,Object... objs); // 根据反射,创建指定类
// 重写hash函数
public int hashCode() {
        return getClass().getName().hashCode();
}

// 示例
@Service
public class UserServiceImpl extends ServiceImpl implements IUserService {}
```

