package com.github.guokaia.mekatok.user.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.user.expose.function.PowerAppServiceDefinition;
import com.github.guokaia.mekatok.user.expose.model.table.Power;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权利表 控制器
 * @author GuoKai
 * @date 2022/2/6
 */
@RestController
@Api(tags = "权力相关接口")
public class PowerRouter extends AbstractRouter implements SimpleCrudSupport<Power>, PowerAppServiceDefinition {
}
