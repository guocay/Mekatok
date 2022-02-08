package com.github.guokaia.mekatok.jdbc.crud;

import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.common.model.PackingNumber;
import com.github.guokaia.mekatok.core.model.store.Table;
import com.github.guokaia.mekatok.jdbc.plus.MapperHolder;
import com.github.guokaia.mekatok.webmvc.message.WebMvcConverter;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 平台内单表的删除操作扩展
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public interface SimpleDeleteSupport<T extends Table<T>> extends WebMvcConverter, ViewBuilder<T> {

    /**
     * 删除单个元素,根据主键
     * @param id 主键
     * @return 操作成功
     */
    @DeleteMapping("/data/{id}")
    @ApiOperation(value = "简单增删改查-删除",notes = "用于删除数据")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    default GeneralPaging<PackingNumber<Integer>> delete(@PathVariable("id") String id){
        return success(MapperHolder.delete(creation(id)));
    }
}
