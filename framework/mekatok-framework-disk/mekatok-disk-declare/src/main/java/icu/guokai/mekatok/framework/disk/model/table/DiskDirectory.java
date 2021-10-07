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

    private static final long serialVersionUID = -4397917841867260632L;

    @TableField("NAME")
    @ApiModelProperty("姓名")
    private String name;

    @TableField("TYPE")
    @ApiModelProperty("类型")
    private String type;

    @TableField("PARENT")
    @ApiModelProperty("父级目录")
    private String parent;

    @TableField("AUTHORITY")
    @ApiModelProperty("权限")
    private String authority;
}
