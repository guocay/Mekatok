package icu.guokai.mekatok.framework.disk.model.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.View;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 目录与文件抽象的对象
 * @author GuoKai
 * @date 2021/11/4
 */
@Data
@Accessors
@ApiModel("目录与文件抽象的对象")
@TableName("V_DISK_ELEMENT")
public class DiskElement extends View<DiskElement> {
    private static final long serialVersionUID = -6836112446984857195L;

    @TableField("ELEMENT_KEY")
    @ApiModelProperty("元素主键")
    private String elementKey;

    @TableField("ELEMENT_TYPE")
    @ApiModelProperty("元素类型")
    private String elementType;

    @TableField("ELEMENT_NAME")
    @ApiModelProperty("元素名称")
    private String elementName;

}
