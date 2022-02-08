package com.github.guokaia.mekatok.user.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.user.expose.function.RolePowerAppServiceDefinition;
import com.github.guokaia.mekatok.user.expose.model.table.RolePower;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色权力表 路由器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@RestController
@Api(tags = "角色权力相关接口")
public class RolePowerRouter extends AbstractRouter implements SimpleCrudSupport<RolePower>, RolePowerAppServiceDefinition {

}
