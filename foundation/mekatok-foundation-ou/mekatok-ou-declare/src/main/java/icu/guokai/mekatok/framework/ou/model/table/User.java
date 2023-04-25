package icu.guokai.mekatok.framework.ou.model.table;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户表
 * @author GuoKai
 * @date 2021/8/16
 */
@Data
@Accessors
@ApiModel("用户对象")
@TableName("T_OU_USER")
public class User extends Table<User> {

    private static final long serialVersionUID = -3929463062703854707L;

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

    /**
     * 根据用户名获取用户表信息
     * 根据用户名获取用户
     *  <code>User.of().setLoginName("username").getUser()</code>
     * @return 用户表信息
     */
    public User queryUser(){
        var list = selectList();
        Assert.isFalse(list.isEmpty(),() -> new UsernameNotFoundException(String.format("User '%s' does not exist.", loginName)));
        return list.get(0);
    }

}
