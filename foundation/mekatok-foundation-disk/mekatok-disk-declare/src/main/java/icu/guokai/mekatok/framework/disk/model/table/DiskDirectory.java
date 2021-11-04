package icu.guokai.mekatok.framework.disk.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 目录对象
 * @author GuoKai
 * @date 2021/8/20
 */
@Data
@Accessors
@ApiModel("目录对象")
@TableName("T_DISK_DIRECTORY")
public class DiskDirectory extends Table<DiskDirectory> {
    private static final long serialVersionUID = 3318282041422493444L;

    @TableField("DIR_CODE")
    @ApiModelProperty("目录编码")
    private String dirCode;

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
