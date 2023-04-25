package com.github.guokaia.mekatok.common.token;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.foreign.Exceptions;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

/**
 * JWT 的静态操作实现类, 基于nimbus-jose-jwt实现.
 * @author GuoKai
 * @date 2022/2/3
 */
public class JwtHolder {

    private static final String USER = "user";

    private static final String NOW = "now";

    /**
     * jwt的header部分
     */
    private static final JWSHeader JWS_HEADER = new JWSHeader(JWSAlgorithm.HS256);

    /**
     * 用于验证签名的对象
     */
    private static final JWSVerifier JWS_VERIFIER;
    /**
     * 用于加密的私钥
     */
    private static final JWSSigner JWS_SIGNER;

    static {
        try {
            JWS_SIGNER = new MACSigner(Global.JWT_PRIVATE_KEY.getBytes());
            JWS_VERIFIER = new MACVerifier(Global.JWT_PRIVATE_KEY.getBytes());
        } catch (Exception e) {
            throw new JwtBuildException(e);
        }
    }

    private JwtHolder(){}

    /**
     * 根据 名称 创建jwt字符串
     * @param userId 内容
     * @return jwt
     */
    public static String create(String userId){
        Payload payload = new Payload(new JSONObject()
            .appendField(USER, userId).appendField(NOW, System.currentTimeMillis()));
        JWSObject obj = new JWSObject(JWS_HEADER, payload);
        Exceptions.run(() -> obj.sign(JWS_SIGNER));
        return obj.serialize();
    }

    /**
     * 根据 jwt字符串 获取 subject
     * @param jwt jwt字符串
     * @return name
     */
    public static String payload(String jwt){
        JWSObject obj = Exceptions.run(() -> JWSObject.parse(jwt));
        return obj.getPayload().toJSONObject().getAsString(USER);
    }

    /**
     * 根据 jwt字符串 验证是否有效
     * @param jwt jwt字符串
     * @return 是否通过验证
     */
    public static Boolean check(String jwt){
        return Exceptions.run(() -> JWSObject.parse(jwt).verify(JWS_VERIFIER));
    }
}
