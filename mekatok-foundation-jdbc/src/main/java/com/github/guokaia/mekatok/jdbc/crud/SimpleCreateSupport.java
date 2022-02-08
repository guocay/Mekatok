package com.github.guokaia.mekatok.jdbc.crud;

import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.core.model.store.Table;
import com.github.guokaia.mekatok.jdbc.plus.MapperHolder;
import com.github.guokaia.mekatok.webmvc.message.WebMvcConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 平台内单表的增加操作扩展
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public interface SimpleCreateSupport<T extends Table<T>> extends WebMvcConverter {

    /**
     * 默认的添加方法
     * @param bean 表单对象
     * @return 对象
     */
    @PostMapping("/data")
    @ApiOperation(value = "简单增删改查-添加",notes = "用于添加数据")
    default GeneralPaging<T> insert(T bean){
        return success(MapperHolder.insert(bean));
    }
}
