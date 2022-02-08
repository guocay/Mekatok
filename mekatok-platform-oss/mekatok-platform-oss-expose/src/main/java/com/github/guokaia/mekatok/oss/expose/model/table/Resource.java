package com.github.guokaia.mekatok.oss.expose.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件表
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("文件表")
@TableName("T_MC_RESOURCE")
public class Resource extends AbstractTable<Resource> {

    @TableField("FILE_NAME")
    @ApiModelProperty("文件名")
    private String fileName;

    @TableField("ORIGINAL_NAME")
    @ApiModelProperty("原文件名")
    private String originalName;

    @TableField("FILE_PARENT")
    @ApiModelProperty("父级目录")
    private String fileParent;

    @TableField("FILE_TYPE")
    @ApiModelProperty("文件类型")
    private String fileType;

    @TableField("FILE_SIZE")
    @ApiModelProperty("文件大小")
    private String fileSize;

    @TableField("IS_TRASH")
    @ApiModelProperty("是否垃圾箱")
    private Boolean trash;

}
