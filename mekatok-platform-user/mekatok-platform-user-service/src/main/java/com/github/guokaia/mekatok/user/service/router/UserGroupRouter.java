package com.github.guokaia.mekatok.user.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.user.expose.function.UserGroupAppServiceDefinition;
import com.github.guokaia.mekatok.user.expose.model.table.UserGroup;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户组织表 路由器
 * @author GuoKai
 * @date 2022/2/6
 */
@RestController
@Api(tags = "用户组织相关接口")
public class UserGroupRouter extends AbstractRouter implements SimpleCrudSupport<UserGroup>, UserGroupAppServiceDefinition {
}
