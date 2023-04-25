package com.github.guokaia.mekatok.jdbc.crud;

import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.core.model.store.Table;
import com.github.guokaia.mekatok.jdbc.plus.MapperHolder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 平台内单表的查询操作扩展
 * @author GuoKai
 * @date 2022/2/2
 */
public interface SimpleRetrieveSupport<T extends Table<T>> extends SimpleViewQuerySupport<T>, TableInfoBuilder<T> {

    /**
     * 默认的查询单个对象函数
     * @param id 对象主键
     * @return 对象数据
     */
    @GetMapping("/data/{id}")
    @ApiOperation(value = "简单增删改查-详情",notes = "用于查询数据通过ID")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    default GeneralPaging<T> detail(@PathVariable("id") String id){
        return success(MapperHolder.get(creation(id)));
    }

}
