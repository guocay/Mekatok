package com.github.guokaia.mekatok.user.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.user.expose.function.UserRoleAppServiceDefinition;
import com.github.guokaia.mekatok.user.expose.model.table.UserRole;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户角色表 路由器
 * @author GuoKai
 * @date 2022/2/6
 */
@RestController
@Api(tags = "用户角色相关接口")
public class UserRoleRouter extends AbstractRouter implements SimpleCrudSupport<UserRole>, UserRoleAppServiceDefinition {
}
