package com.github.guokaia.mekatok.auth.service.handler;

import com.github.guokaia.mekatok.auth.expose.model.packing.SecurityUser;
import com.github.guokaia.mekatok.core.handler.IHadnler;

/**
 * 认证服务接口
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/7
 */
public interface AuthHandler extends IHadnler {

    /**
     * 登录
     * @param loginName 用户名
     * @param password 密码
     * @return jwt 字符串
     */
    String login(String loginName, String password);

    /**
     * 退出
     * @param token JWT
     * @return 成功
     */
    Boolean logout(String token);

    /**
     * 当前用户
     * @param userId 用户ID
     * @return 用户
     */
    SecurityUser current(String userId);

    /**
     * 验证是否已经登录
     * @param token JWT
     * @return 成功
     */
    Boolean checkLogin(String token);
}
