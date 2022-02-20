package com.github.guokaia.mekatok.auth.service.handler;

import com.github.guokaia.mekatok.auth.expose.model.packing.SecurityUser;
import com.github.guokaia.mekatok.auth.service.provider.UserServicePorvider;
import com.github.guokaia.mekatok.common.handler.AbstractHandler;
import com.github.guokaia.mekatok.common.token.JwtHolder;
import com.github.guokaia.mekatok.user.expose.model.table.User;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.github.guokaia.mekatok.common.Global.USER_LOGIN_STATUS_CACHE_NAME;

/**
 * 认证服务实现
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/7
 */
@Service
public class AuthHandlerImpl extends AbstractHandler implements AuthHandler {

    private final UserServicePorvider userService;

    private final RedissonClient redissonClient;

    /**
     * token有效期
     */
    @Value("${mekatok.token-ttl:30}")
    private Long tokenTtl;

    /**
     * 用户登录的缓存
     */
    private RMapCache<String, String> userLoginStatusCache;

    public AuthHandlerImpl(RedissonClient client, UserServicePorvider userService) {
        this.redissonClient = client;
        this.userService = userService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        userLoginStatusCache = redissonClient.getMapCache(USER_LOGIN_STATUS_CACHE_NAME);
    }

    @Override
    public String login(String loginName, String password) {
        User user = userService.matches(loginName, password).findFirst();
        return doLogin(user);
    }

    /**
     * 保存用户的登录态
     * @param user 用户
     * @return jwt字符串
     */
    private String doLogin(User user) {
        String payload = user.getId();
        String jwt = JwtHolder.create(payload);
        userLoginStatusCache.fastPut(payload, jwt, tokenTtl, TimeUnit.MINUTES);
        return jwt;
    }

    @Override
    public Boolean logout(String token) {
        userLoginStatusCache.remove(JwtHolder.payload(token));
        return Boolean.TRUE;
    }

    @Override
    public SecurityUser current(String userId) {
        // todo 这还没写
        // 第一步,获取用户
        // 第二步,获取角色
        // 第三步,获取分组
        // 第四步,获取权力
        return new SecurityUser(null, null, null, null);
    }

    @Override
    public Boolean checkLogin(String token) {
        // 第一步,转换信息
        String payload = JwtHolder.payload(token);
        // 第二步,查看 是否存在于Redis中
        String jwt = userLoginStatusCache.get(payload);
        if(Objects.isNull(jwt) || !jwt.equals(token)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }



}
