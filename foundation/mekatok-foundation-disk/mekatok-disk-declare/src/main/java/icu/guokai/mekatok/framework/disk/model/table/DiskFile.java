package icu.guokai.mekatok.framework.disk.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件对象
 * @author GuoKai
 * @date 2021/8/20
 */
@Data
@Accessors
@ApiModel("文件对象")
@TableName("T_DISK_FILE")
public class DiskFile extends Table<DiskFile> {
    private static final long serialVersionUID = 7303959609731870740L;

    @TableField("FILE_NAME")
    @ApiModelProperty("文件名")
    private String fileName;

    @TableField("ORIGINAL_NAME")
    @ApiModelProperty("原文件名")
    private String originalName;

    @TableField("FILE_PARENT")
    @ApiModelProperty("父级目录")
    private String fileParent;

    @TableField("IS_TRASH")
    @ApiModelProperty("是否垃圾箱")
    private Boolean trash;

    @TableField("FILE_TYPE")
    @ApiModelProperty("文件类型")
    private String fileType;

    @TableField("FILE_SIZE")
    @ApiModelProperty("文件大小")
    private String fileSize;
}
