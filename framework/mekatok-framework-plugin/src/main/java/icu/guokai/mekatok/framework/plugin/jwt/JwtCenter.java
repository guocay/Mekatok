package icu.guokai.mekatok.framework.plugin.jwt;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import icu.guokai.mekatok.framework.core.constant.Global;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;

import java.util.Date;

/**
 * Json Web Token 工具类
 * @author GuoKai
 * @date 2021/8/16
 */
@Slf4j
@SuppressWarnings("all")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtCenter extends cn.hutool.jwt.JWTUtil {
    /**
     * 加密时用到的Key
     */
    private static final byte[] KEY = Global.JWT_PRIVATE_KEY.getBytes();

    /**
     * jwt header
     */
    private static final JSONObject HEADERS = new JWTHeader()
            .getClaimsJson().set(JWTHeader.ALGORITHM, "HS256");

    /**
     * 根据用户名称生成JWT信息
     * @param name 用户主键
     * @return JWT字符串
     */
    public static String createTokenBySub(String name){
        var now = new Date();
        var bodys = new JWTPayload()
                // 设置Token的ID
                .setJWTId(IdUtil.fastSimpleUUID())
                // 设置签发主体,JWT签发人
                .setIssuer(Global.APPLICATION_NAME)
                // 设置授权主体,JWT所有人
                .setSubject(name)
                // 设置签发时间
                .setIssuedAt(now)
                // 设置授权开始时间
                .setNotBefore(now)
                // 设置授权结束时间
                .setExpiresAt(DateUtil.offsetMillisecond(now, Global.JWT_TTL)).getClaimsJson();
        var jwt = createToken(HEADERS, bodys, KEY);
        log.info("为用户 {} 颁发新凭证, Token值为: {}", name, jwt);
        return jwt;
    }


    /**
     * 根据 JWT字符串 获取 Subject
     * @param jwt JWT字符串
     * @return 字符串中存储的数据 - 当前只有一个用户名
     */
    public static String getSubjectByToken(String jwt){
        return checkJwt(jwt) ? (String) JWTUtil.parseToken(jwt).setKey(KEY).getPayload("sub") : null;
    }

    /**
     * 验证 jwt 字符串的签名和是否在有效期内.
     * @param jwt
     * @return 是否有效
     */
    public static Boolean checkJwt(String jwt){
        var success = JWTUtil.parseToken(jwt).setKey(KEY).validate(0);
        if(!success){
            log.error("当前凭证验证未通过, Token值为: {}", jwt);
        }
        return success;
    }

    /**
     * 根据认证对象生成JWT信息
     * @param auth 认证对象
     * @return JWT字符串
     */
    public static String createTokenByAuth(Authentication auth){
        auth.getPrincipal();
        return createTokenBySub(auth.getName());
    }
}
