package com.github.guokaia.mekatok.common.model;

import com.github.guokaia.mekatok.core.model.Packing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数字类型包装类
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数字容器")
public class PackingNumber<T extends Number> implements Packing<PackingNumber<T>>{

    /**
     * 值
     */
    @ApiModelProperty("值")
    private T value;

}
