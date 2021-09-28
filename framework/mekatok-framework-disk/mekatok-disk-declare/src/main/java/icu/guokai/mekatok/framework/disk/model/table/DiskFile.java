package icu.guokai.mekatok.framework.disk.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.entity.Table;
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

    @TableField("NAME")
    @ApiModelProperty("文件名")
    private String name;

    @TableField("ORIGINAL_NAME")
    @ApiModelProperty("原文件名")
    private String originalName;

    @TableField("PARENT")
    @ApiModelProperty("父级目录")
    private String parent;

    @TableField("ORIGINAL_DIR")
    @ApiModelProperty("原目录ID(回收站特有)")
    private String originalDir;

    @TableField("TYPE")
    @ApiModelProperty("文件类型")
    private String type;

    @TableField("SIZE")
    @ApiModelProperty("文件大小")
    private String size;
}
