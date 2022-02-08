package com.github.guokaia.mekatok.auth.expose.function;

import com.github.guokaia.mekatok.auth.expose.model.packing.SecurityUser;
import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.common.model.PackingBoolean;
import com.github.guokaia.mekatok.common.model.PackingChar;
import org.springframework.web.bind.annotation.*;

/**
 * 认证服务定义
 * @author GuoKai
 * @date 2022/2/7
 */
@RequestMapping(Global.BASIC_SERVICE_PATH + "/auth")
public interface AuthAppServiceDefinition{

    @PostMapping("/login")
    GeneralPaging<PackingChar<String>> login(@RequestParam("loginName") String loginName, @RequestParam("password") String password);

    @DeleteMapping("/logout")
    GeneralPaging<PackingBoolean> logout();

    @GetMapping("/current")
    GeneralPaging<SecurityUser> current();

    @GetMapping("/check")
    GeneralPaging<PackingBoolean> checkLogin(@RequestParam("token") String token);

}
