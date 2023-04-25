package icu.guokai.mekatok.framework.stomp.plugin;

import cn.hutool.core.lang.Assert;
import icu.guokai.mekatok.framework.plugin.jwt.JwtCenter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.security.Principal;

/**
 * stomp 用户认证相关对象
 * @author GuoKai
 * @date 2021/8/24
 */
public class SimplePrincipal implements Principal {

    /**
     * 安全唯一标识 - 名称
     */
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String name;

    /**
     * 加载安全对象
     * @param token 登录时颁发的jwt
     * @return 安全对象
     */
    public static SimplePrincipal of(String token) {
        var principal = new SimplePrincipal();
        var name = JwtCenter.getSubjectByToken(token);
        Assert.notNull(name, RuntimeException::new);
        return principal.setName(name);
    }
}
