package icu.guokai.mekatok.framework.dic.route;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.core.route.support.SimpleCrudSupport;
import icu.guokai.mekatok.framework.dic.DicModuleInfo;
import icu.guokai.mekatok.framework.dic.model.table.Dictionary;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于字典服务的路由管理器
 * @author GuoKai
 * @date 2021/8/19
 */
@RestController
@SuppressWarnings("all")
@Api(tags = "字典相关接口")
@ApiSupport(author = Global.GK)
@RequestMapping(DicModuleInfo.MODULE_ROUTE_URI)
public class DictionaryRouter extends Router implements SimpleCrudSupport<Dictionary> {

    @Override
    public Dictionary insertBefore(Dictionary bean) {
        return bean.setKey(String.format("%s%s",bean.getParent(),bean.getKey()));
    }
}
