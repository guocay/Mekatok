package com.github.guokaia.mekatok.common.bcrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 拷贝自:<br/>
 * spring-security-core包 org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/6
 */
@SuppressWarnings("all")
public class BCryptEncoder {

    private Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final int strength;

    private final BCryptVersion version;

    private final SecureRandom random;

    public BCryptEncoder() {
        this(-1);
    }

    /**
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptEncoder(int strength) {
        this(strength, null);
    }

    /**
     * @param version the version of bcrypt, can be 2a,2b,2y
     */
    public BCryptEncoder(BCryptVersion version) {
        this(version, null);
    }

    /**
     * @param version the version of bcrypt, can be 2a,2b,2y
     * @param random the secure random instance to use
     */
    public BCryptEncoder(BCryptVersion version, SecureRandom random) {
        this(version, -1, random);
    }

    /**
     * @param strength the log rounds to use, between 4 and 31
     * @param random the secure random instance to use
     */
    public BCryptEncoder(int strength, SecureRandom random) {
        this(BCryptVersion.$2A, strength, random);
    }

    /**
     * @param version the version of bcrypt, can be 2a,2b,2y
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptEncoder(BCryptVersion version, int strength) {
        this(version, strength, null);
    }

    /**
     * @param version the version of bcrypt, can be 2a,2b,2y
     * @param strength the log rounds to use, between 4 and 31
     * @param random the secure random instance to use
     */
    public BCryptEncoder(BCryptVersion version, int strength, SecureRandom random) {
        if (strength != -1 && (strength < BCrypt.MIN_LOG_ROUNDS || strength > BCrypt.MAX_LOG_ROUNDS)) {
            throw new IllegalArgumentException("Bad strength");
        }
        this.version = version;
        this.strength = (strength == -1) ? 10 : strength;
        this.random = random;
    }

    /**
     * 该函数会随机生成盐后, 并将盐写入加密后的字符串中.
     * 所以, 即使相同的密码每次调用生成的密文都不一致.
     * @param rawPassword 密码
     * @return 加密后文本
     */
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        String salt = getSalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    private String getSalt() {
        if (this.random != null) {
            return BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
        }
        return BCrypt.gensalt(this.version.getVersion(), this.strength);
    }

    /**
     * 匹配密码是否一致
     * @param rawPassword 原始密码
     * @param encodedPassword 数据库中加密后的密码
     * @return 匹配成功
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0) {
            this.logger.warn("Empty encoded password");
            return false;
        }
        if (!this.BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            this.logger.warn("Encoded password does not look like BCrypt");
            return false;
        }
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }

    public boolean upgradeEncoding(String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            this.logger.warn("Empty encoded password");
            return false;
        }
        Matcher matcher = this.BCRYPT_PATTERN.matcher(encodedPassword);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Encoded password does not look like BCrypt: " + encodedPassword);
        }
        int strength = Integer.parseInt(matcher.group(2));
        return strength < this.strength;
    }

    /**
     * Stores the default bcrypt version for use in configuration.
     */
    public enum BCryptVersion {

        $2A("$2a"),

        $2Y("$2y"),

        $2B("$2b");

        private final String version;

        BCryptVersion(String version) {
            this.version = version;
        }

        public String getVersion() {
            return this.version;
        }

    }
}
