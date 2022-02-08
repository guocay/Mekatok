package com.github.guokaia.mekatok.dic.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 字典表
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("字典表")
@TableName("T_MC_DICTIONARY")
public class Dictionary extends AbstractTable<Dictionary> {

    @TableField("CODE")
    @ApiModelProperty("键")
    private String code;

    @TableField("DETAIL")
    @ApiModelProperty("值")
    private String detail;

    @TableField("PARENT")
    @ApiModelProperty("上级键")
    private String parent;

}
