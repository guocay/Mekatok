package com.github.guokaia.mekatok.user.expose.function;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.user.expose.model.table.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户控制器 暴露服务
 * @author GuoKai
 * @date 2022/2/6
 */
@RequestMapping(Global.BASIC_SERVICE_PATH + "/user")
public interface UserAppServiceDefinition {

    /**
     * 验证用户名密码
     * @param loginName 用户名
     * @param password 密码
     * @return 成功
     */
    @GetMapping("/auth/matches")
    GeneralPaging<User> matches(@RequestParam("loginName") String loginName, @RequestParam("password") String password);

}
