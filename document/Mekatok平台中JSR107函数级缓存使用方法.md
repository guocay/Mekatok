### 准备

```xml
<!-- 引入缓存实现模块 -->
<dependency>
  <groupId>icu.guokai</groupId>
  <artifactId>mekatok-framework-cache</artifactId>
</dependency>
```

```java
/**
 * 添加注解 EnableRedisCache 开启缓存
 */
@EnableRedisCache
public class Application(){
  public static void main(String[] args){
    SpringApplication.run(Application.class, args);
  }
}
```

### 使用

1. **@CachePut**：既调用方法，又更新缓存数据；同步更新缓存
2. **@Cacheable**: 标注的方法在执行之前会先检查缓存中有没有这个数据，默认按照参数的值作为缓存的key去查询缓存，如果没有就运行该方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
3. **@CacheEvict**：缓存清除
4. **@Caching**: 综合上面介绍的几个注解，用来定义较为复杂的缓存规则
5. **@CacheConfig**: 允许你以类似的方式配置相同的概念。

