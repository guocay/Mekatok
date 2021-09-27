package icu.guokai.mekatok.framework.plugin.jwt;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import icu.guokai.mekatok.framework.core.constant.Global;
import io.jsonwebtoken.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SignatureException;
import java.util.Date;

/**
 * Json Web Token 工具类
 * @author GuoKai
 * @date 2021/8/16
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtil {
    /**
     * Key
     */
    private static final Key KEY = new SecretKeySpec(Global.JWT_PRIVATE_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

    /**
     * 用于解析JWT的转换器
     */
    private static final JwtParser PARSER = Jwts.parserBuilder().setSigningKey(KEY).build();

    /**
     * 根据用户名称生成JWT信息
     * @param name 用户主键
     * @return JWT字符串
     */
    public static String createToken(String name){
        var now = new Date();
        var jwt = Jwts.builder()
                // 设置Token的ID
                .setId(IdUtil.fastSimpleUUID())
                // 设置签发主体,JWT签发人
                .setIssuer(Global.APPLICATION_NAME)
                // 设置授权主体,JWT所有人
                .setSubject(name)
                // 设置签发时间
                .setIssuedAt(now)
                // 设置授权开始时间
                .setNotBefore(now)
                // 设置授权结束时间
                .setExpiration(DateUtil.offsetMillisecond(now,Global.JWT_TTL))
                .signWith(KEY).compact();
        log.info("为用户 {} 颁发新凭证, Token值为 {}", name, jwt);
        return jwt;
    }

    /**
     * 根据 JWT字符串 获取 Subject
     * @param jwt JWT字符串
     * @return 字符串中存储的数据 - 当前只有一个用户名
     */
    @SuppressWarnings("all")
    public static String getSubjectByToken(String jwt){
        String name = null;
        try {
            name = PARSER.parseClaimsJws(jwt).getBody().getSubject();
        }catch (Exception ex){
            if(ex instanceof ExpiredJwtException){
                log.error("当前凭证已过期, Token值为: {}", jwt);
            }else if (ex instanceof SignatureException){
                log.error("当前凭证签名算法与本地不一致, Token值为: {}", jwt);
            }else if(ex instanceof MalformedJwtException){
                log.error("当前凭证未正确构造, Token值为: {}", jwt);
            }else {
                log.error("",ex);
            }
        }
        return name;
    }

    /**
     * 根据认证对象生成JWT信息
     * @param auth 认证对象
     * @return JWT字符串
     */
    public static String createToken(Authentication auth){
        auth.getPrincipal();
        return createToken(auth.getName());
    }
}
