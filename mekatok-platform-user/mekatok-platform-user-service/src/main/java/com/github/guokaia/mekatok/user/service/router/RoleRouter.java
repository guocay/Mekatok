package com.github.guokaia.mekatok.user.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.user.expose.function.RoleAppServiceDefinition;
import com.github.guokaia.mekatok.user.expose.model.table.Role;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色 路由器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@RestController
@Api(tags = "角色相关接口")
public class RoleRouter extends AbstractRouter implements SimpleCrudSupport<Role>, RoleAppServiceDefinition {
}
