package icu.guokai.mekatok.framework.disk.model.tran;

import icu.guokai.mekatok.framework.core.model.dto.Transport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * 文件传输对象
 * @author GuoKai
 * @date 2021/11/4
 */
@Data
@Accessors
@ApiModel("文件传输对象")
public class DiskFileTran implements Transport {
    private static final long serialVersionUID = -3956123398561188070L;

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("原文件名")
    private String originalName;

    @ApiModelProperty("文件对象")
    private byte[] file;
}
