## 缓存的使用

> Mekatok平台中,缓存为必须开启的功能.
>
> 在对象持久化,用户登录凭证时必须使用缓存.

Mekatok中,一共有两个缓存实现的方案,Redis和EhCache两种.当前仅实现了Redis缓存方案,EhCache仅提供个接口而未实现.

### 准备阶段

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

### 缓存有效期

```java
import icu.guokai.mekatok.framework.cache.redis.deploy.RedisCacheGroup;
import java.time.Duration;

@Component
public UserCache implements RedisCacheGroup {
  // 设置缓存名称
  @Override
  public String getCache() {
    return "cache-name";
  }

  // 设置缓存过期时间
  @Override
  public Duration getTtl() {
    return Duration.ofMillis(50);
  }
}
```

### 静态调用

```java
import icu.guokai.mekatok.framework.cache.CacheCenter;
import org.springframework.cache.Cache;

// 获取 缓存 集合
Cache cache = CacheCenter.cache("cache-name");

// 获取缓存中的值,T(泛型)代表value的类型
T value = CacheCenter.<T>get("cache-name", "cache-key");

// 删除指定缓存集合中的数据.
CacheCenter.evict("cache-name", "cache-key");

// 为指定缓存集合放入数据.
CacheCenter.put("cache-name", "cache-key", "cache-value");

// 为指定缓存集合放入数据.
Cache.ValueWrapper value = CacheCenter.putIfAbsent("cache-name", "cache-key", "cache-value");

// 缓存中是否存在当前值
boolean isExist = CacheCenter.exist("cache-name", "cache-key");

// 获取 Redis 模板 对象
RedisTemplate<String, Object> template = CacheCenter.template();

```

