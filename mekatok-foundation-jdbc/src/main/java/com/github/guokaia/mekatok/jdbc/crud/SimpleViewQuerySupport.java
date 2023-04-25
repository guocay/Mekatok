package com.github.guokaia.mekatok.jdbc.crud;

import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.core.model.store.View;
import com.github.guokaia.mekatok.jdbc.page.PagingHolder;
import com.github.guokaia.mekatok.jdbc.plus.MapperHolder;
import com.github.guokaia.mekatok.webmvc.message.WebMvcConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 平台内视图的查询操作扩展
 * @author GuoKai
 * @date 2022/2/4
 */
public interface SimpleViewQuerySupport<T extends View<T>> extends WebMvcConverter {

    /**
     * 根据查询条件 查询分页数据
     * @param bean 对象查询条件
     * @return 对象数据
     */
    @GetMapping("/data/page")
    @ApiOperation(value = "简单增删改查-分页",notes = "用于查询数据通过分页")
    default GeneralPaging<T> page(T bean){
        return PagingHolder.build(MapperHolder.page(bean));
    }

    /**
     * 根据查询条件 查询分页数据
     * @param bean 对象查询条件
     * @return 对象数据
     */
    @GetMapping("/data/list")
    @ApiOperation(value = "简单增删改查-列表",notes = "用于查询数据")
    default GeneralPaging<T> list(T bean){
        return GeneralPaging.of(MapperHolder.list(bean));
    }


}
