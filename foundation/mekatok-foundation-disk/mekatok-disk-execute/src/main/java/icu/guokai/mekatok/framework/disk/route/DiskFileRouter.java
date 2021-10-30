package icu.guokai.mekatok.framework.disk.route;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.core.route.support.SimpleCrudSupport;
import icu.guokai.mekatok.framework.disk.DiskModuleInfo;
import icu.guokai.mekatok.framework.disk.model.table.DiskFile;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件服务相关接口
 * @author GuoKai
 * @date 2021/8/20
 */
@RestController
@Api(tags = "文件相关接口")
@ApiSupport(author = Global.GK)
@RequestMapping(DiskModuleInfo.MODULE_ROUTE_URI + "/file")
public class DiskFileRouter extends Router implements SimpleCrudSupport<DiskFile> {
}
