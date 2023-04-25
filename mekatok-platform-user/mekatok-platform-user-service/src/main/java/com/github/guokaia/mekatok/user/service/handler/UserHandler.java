package com.github.guokaia.mekatok.user.service.handler;

import com.github.guokaia.mekatok.core.handler.IHadnler;
import com.github.guokaia.mekatok.user.expose.model.table.User;

/**
 * 用户处理器接口
 * @author GuoKai
 * @date 2022/2/7
 */
public interface UserHandler extends IHadnler {

    /**
     * 校验用户名密码
     * @param loginName 用户名
     * @param password 密码
     * @return 成功
     */
    User matches(String loginName, String password);
}
