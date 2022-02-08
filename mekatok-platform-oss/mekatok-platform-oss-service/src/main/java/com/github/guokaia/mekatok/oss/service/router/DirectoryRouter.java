package com.github.guokaia.mekatok.oss.service.router;

import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.oss.expose.function.DirectoryAppServiceDefinition;
import com.github.guokaia.mekatok.oss.expose.model.table.Directory;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 目录
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@RestController
@Api(tags = "目录相关接口")
public class DirectoryRouter extends AbstractRouter implements SimpleCrudSupport<Directory>, DirectoryAppServiceDefinition {
}
