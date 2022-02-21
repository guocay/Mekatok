package com.github.guokaia.mekatok.auth.service.router;

import com.github.guokaia.mekatok.auth.expose.function.AuthAppServiceDefinition;
import com.github.guokaia.mekatok.auth.expose.model.packing.SecurityUser;
import com.github.guokaia.mekatok.auth.service.handler.AuthHandler;
import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.common.model.PackingBoolean;
import com.github.guokaia.mekatok.common.model.PackingChar;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import com.github.guokaia.mekatok.webmvc.servlet.ServletHolder;
import com.github.guokaia.mekatok.webmvc.whoami.MyselfHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证 路由器
 * @author GuoKai
 * @date 2022/2/7
 */
@RestController
@Api(tags = "认证相关服务")
public class AuthRouter extends AbstractRouter implements AuthAppServiceDefinition {

    private final AuthHandler authHandler;

    /**
     * 构造器 注入
     */
    public AuthRouter(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    @Override
    @ApiOperation(value = "用户登录")
    public GeneralPaging<PackingChar<String>> login(String loginName, String password) {
        return success(authHandler.login(loginName, password));
    }

    @Override
    @ApiOperation(value = "用户退出")
    public GeneralPaging<PackingBoolean> logout() {
        return success(authHandler.logout(ServletHolder.getHeader(Global.JWT_TOKEN)));
    }

    @Override
    @ApiOperation(value = "当前用户")
    public GeneralPaging<SecurityUser> current() {
        return success(authHandler.current(MyselfHolder.get()));
    }

    @Override
    @ApiOperation(value = "验证登录")
    public GeneralPaging<PackingBoolean> checkLogin(String token) {
        return success(authHandler.checkLogin(token));
    }
}
