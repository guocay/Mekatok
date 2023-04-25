package com.github.guokaia.mekatok.user.expose.model.table;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.guokaia.mekatok.common.model.store.AbstractTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户表
 * @author GuoKai
 * @date 2022/2/6
 */
@Data
@Accessors
@ApiModel("用户表")
@TableName("T_MC_USER")
public class User extends AbstractTable<User> {

    @TableField(value = "LOGIN_NAME")
    @ApiModelProperty("登录名称")
    private String loginName;

    @TableField(value = "REAL_NAME",condition = SqlCondition.LIKE)
    @ApiModelProperty("真实名称")
    private String realName;

    @JsonIgnore
    @TableField("PASSWORD")
    @ApiModelProperty("登录密码")
    private String password;

}
