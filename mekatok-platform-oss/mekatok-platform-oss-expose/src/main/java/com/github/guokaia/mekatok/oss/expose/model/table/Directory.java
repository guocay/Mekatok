package com.github.guokaia.mekatok.oss.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 目录表
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("目录表")
@TableName("T_MC_DIRECTORY")
public class Directory extends AbstractTable<Directory> {

    @TableField("DIR_NAME")
    @ApiModelProperty("目录名称")
    private String dirName;

    @TableField("PARENT_DIR")
    @ApiModelProperty("父级目录")
    private String parentDir;

    @TableField("IS_TRASH")
    @ApiModelProperty("是否垃圾箱")
    private Boolean trash;

}
