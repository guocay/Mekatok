package com.github.guokaia.mekatok.jdbc.crud;

import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.common.model.PackingNumber;
import com.github.guokaia.mekatok.core.model.store.Table;
import com.github.guokaia.mekatok.jdbc.plus.MapperHolder;
import com.github.guokaia.mekatok.webmvc.message.WebMvcConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * 平台内单表的更新操作扩展
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public interface SimpleUpdateSupport<T extends Table<T>> extends WebMvcConverter {

    /**
     * 更新默认元素,通过主键
     * @param bean 对象(必须包含主键)
     * @return 操作成功
     */
    @PutMapping("/data")
    @ApiOperation(value = "简单增删改查-更新",notes = "用于更新数据")
    default GeneralPaging<PackingNumber<Integer>> update(T bean){
        return success(MapperHolder.update(bean));
    }
}
