package icu.guokai.mekatok.framework.security.route;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.plugin.jwt.JwtCenter;
import icu.guokai.mekatok.framework.security.service.SimpleSecurityUserCache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简单登录的Router
 * @author GuoKai
 * @date 2021/8/18
 */
@RestController
@Api(tags = "登录相关接口")
@SuppressWarnings("all")
@ApiSupport(author = Global.GK)
public class SimpleSecurityRouter extends BasicSecurityRouter {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private SimpleSecurityUserCache cache;

    @PostMapping(LOGIN_URL)
    @ApiOperation(value = "登录接口", notes = "用户认证登录服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class)
    })
    public ResponseEntity<String> login(@NonNull String username, @NonNull String password){
        // Assert.isFalse(cache.containsKey(username), () -> USER_LOGGED);
        var auth = new UsernamePasswordAuthenticationToken(username,password);
        // 认证并装载
        manager.authenticate(auth);
        return success(JwtCenter.createTokenByAuth(auth));
    }

}
