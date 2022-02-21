package com.github.guokaia.mekatok.common.model;

import com.github.guokaia.mekatok.core.model.Packing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 字符串包装壳
 * @author GuoKai
 * @date 2022/2/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("字符容器")
public class PackingChar<T extends CharSequence> implements Packing<PackingChar<T>> {

    /**
     * 值
     */
    @ApiModelProperty("值")
    private T value;

}
