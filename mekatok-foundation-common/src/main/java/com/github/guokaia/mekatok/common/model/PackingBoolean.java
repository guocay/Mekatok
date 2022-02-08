package com.github.guokaia.mekatok.common.model;

import com.github.guokaia.mekatok.core.model.Packing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 布尔类型包装类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("布尔容器")
public class PackingBoolean implements Packing<PackingBoolean> {

    /**
     * 值
     */
    @ApiModelProperty("值")
    private Boolean value;

}
