package icu.guokai.mekatok.framework.dic.model.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 字典对象信息
 * @author GuoKai
 * @date 2021/8/19
 */
@Data
@Accessors
@ApiModel("字典对象")
@TableName("T_DIC_TREE")
public class Dictionary extends Table<Dictionary> {

    private static final long serialVersionUID = 3387962671341264028L;

    @TableField("KEY")
    @ApiModelProperty("键")
    private String key;

    @TableField("VALUE")
    @ApiModelProperty("值")
    private String value;

    @TableField("PARENT")
    @ApiModelProperty("上级的键")
    private String parent;
}
