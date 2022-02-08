package com.github.guokaia.mekatok.dic.service.router;

import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.dic.expose.function.DictionaryAppServiceDefinition;
import com.github.guokaia.mekatok.dic.expose.model.table.Dictionary;
import com.github.guokaia.mekatok.jdbc.crud.SimpleCrudSupport;
import com.github.guokaia.mekatok.webmvc.router.AbstractRouter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典 路由器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@RestController
@Api(tags = "字典相关接口")
public class DictionaryRouter extends AbstractRouter implements SimpleCrudSupport<Dictionary>, DictionaryAppServiceDefinition {

    @Override
    public GeneralPaging<Dictionary> page(Dictionary bean) {
        return SimpleCrudSupport.super.page(bean);
    }

    @Override
    public GeneralPaging<Dictionary> detail(String id) {
        return SimpleCrudSupport.super.detail(id);
    }
}
