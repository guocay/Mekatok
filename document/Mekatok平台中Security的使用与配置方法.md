### 准备

```xml
<!-- 引入安全模块 -->
<dependency>
  <groupId>icu.guokai</groupId>
  <artifactId>mekatok-framework-security</artifactId>
</dependency>
```

```java
// 开启简单用户验证体系
// 还可以使用@EnableOauthSecurity注解,开启统一认证(PS:仅预留了接口,还未实现.).
import icu.guokai.mekatok.framework.security.configure.simple.EnableSimpleSecurity;

@EnableSimpleSecurity
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

```yaml
info:
  application:
    security:
    	# 设置是否开启权限校验
      enable: false
      # 设置用户token过期时间
      ttl: 1800000
      # 设置保护的url,其下的所有连接均被保护
      permit:
        - /demo
```

### 开放接口

```java
import icu.guokai.mekatok.framework.security.user.SecurityUser;

// 登录接口
@PostMapping("/login")
public ResponseEntity<String> login(@NonNull String username, @NonNull String password);

// 退出接口
@GetMapping("/logout")
public ResponseEntity<Boolean> logout();

// 当前用户
@GetMapping("/currentUser")
public ResponseEntity<SecurityUser> currentUser();

// http401响应
@RequestMapping("/401")
public ResponseEntity<String> unAuthorized();

// http403响应
@RequestMapping("/403")
public ResponseEntity<String> forbidden();
```

### 使用

```java
import icu.guokai.mekatok.framework.security.util.UserContextHolder;
import icu.guokai.mekatok.framework.ou.model.view.UserOrganizeView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// 获取用户登录凭证
Authentication au = UserContextHolder.getAuthentication();
// 获取用户详情
UserDetails user = UserContextHolder.getUserDetails();
// 获取用户主键
String id = UserContextHolder.getUserId();
// 获取登录名
String name = UserContextHolder.getLoginName();
// 获取权限集合
Set<GrantedAuthority> au = UserContextHolder.getAuthorities();
// 获取组织集合
Set<UserOrganizeView> orgs = UserContextHolder.getOrganizes();
```

