package com.github.guokaia.mekatok.oss.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.oss.expose.function.ResourceAppServiceDefinition;
import com.github.guokaia.mekatok.oss.expose.model.table.Resource;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件 路由器
 * @author GuoKai
 * @date 2022/2/6
 */
@RestController
@Api(tags = "文件相关接口")
public class ResourceRouter extends AbstractRouter implements SimpleCrudSupport<Resource>, ResourceAppServiceDefinition {
}
