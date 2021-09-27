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
import icu.guokai.mekatok.framework.core.mapper.Mapper;
// 定义针对单个表(或视图)的数据操作对象.
// Mapper必须存在, AR模式的数据保存需要依赖这个Mapper.

// Mapper接口的泛型用于指定当前类对应的是哪张表.

// MyBatis允许我们通过xml文件定义SQL,项目依赖的mapper.xml文件需要放在 classpath*:/mapper/**/*.xml

// 继承Mapper,默认会提供以下函数(除Mybatis-Plus提供的BaseMapper以外).
default Boolean hasThat(String id); // 判断当前主键是否存在.
default Optional<T> findFirst(Wrapper<T> wrapper); // 查询符合查询条件的第一条数据.

public interface UserMapper extends Mapper<User> {}
```

