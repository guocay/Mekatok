package com.github.guokaia.mekatok.user.service.router;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.common.model.PackingNumber;
import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.user.expose.function.UserAppServiceDefinition;
import com.github.guokaia.mekatok.user.expose.model.table.User;
import com.github.guokaia.mekatok.user.service.handler.UserHandler;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户 路由器
 * @author GuoKai
 * @date 2022/2/6
 */
@RestController
@Api(tags = "用户相关接口")
public class UserRouter extends AbstractRouter implements SimpleCrudSupport<User>, UserAppServiceDefinition {

    private final UserHandler userHandler;

    public UserRouter(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Override
    public GeneralPaging<PackingNumber<Integer>> update(User bean) {
        /*
            不允许更新密码
         */
        return SimpleCrudSupport.super.update(bean.setPassword(null));
    }

    @Override
    public GeneralPaging<User> insert(User bean) {
        /*
            新增时,填充默认密码
         */
        return SimpleCrudSupport.super.insert(bean.setPassword(Global.ENCODER.encode(Global.DEFAULT_USER_PASSWORD)));
    }

    @Override
    @ApiIgnore
    public GeneralPaging<User> matches(String loginName, String password) {
        return success(userHandler.matches(loginName, password));
    }
}
