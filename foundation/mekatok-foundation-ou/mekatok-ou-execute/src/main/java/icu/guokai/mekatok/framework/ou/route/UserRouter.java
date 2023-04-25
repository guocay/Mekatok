package icu.guokai.mekatok.framework.ou.route;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.core.route.support.SimpleCrudSupport;
import icu.guokai.mekatok.framework.ou.OuModuleInfo;
import icu.guokai.mekatok.framework.ou.model.table.User;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关服务的路由
 * @author GuoKai
 * @date 2021/8/16
 */
@RestController
@Api(tags = "用户相关接口")
@ApiSupport(author = Global.GK)
@RequestMapping(OuModuleInfo.MODULE_ROUTE_URI + "/user")
public class UserRouter extends Router implements SimpleCrudSupport<User> {

    @Override
    public User insertBefore(User bean) {
        return bean.setPassword(Global.ENCODER.encode(bean.getPassword()));
    }
}
