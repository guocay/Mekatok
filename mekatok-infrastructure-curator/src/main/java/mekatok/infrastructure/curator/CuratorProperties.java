package mekatok.infrastructure.curator;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Curator 相关配置属性
 * @author GuoCay
 * @since 2023.03.15
 */
@ConfigurationProperties("zookeeper.curator")
public class CuratorProperties {

    /**
     * 连接字符串
     */
    private String connectionString;
    /**
     * 命名空间
     */
    private String namespace;
    /**
     * 字符集
     */
    private String charset = "utf8";
    /**
     * session 超时
     */
    private int sessionTimeoutMs = 60000;
    /**
     * 连接超时
     */
    private int connectionTimeoutMs = 15000;
    /**
     * 最大等待关闭时间
     */
    private int maxCloseWaitMs = 1000;
    /**
     * 默认数据
     */
    private String defaultData = "";
    /**
     * 是否只读
     */
    private boolean canBeReadOnly = false;
    /**
     * 是否使用容器
     */
    private boolean useContainerParentsIfAvailable = true;
    /**
     * 线程工厂类名
     */
    private String threadFactoryClassName;
    /**
     * 重试机制
     */
    private Retry retry = new Retry();
    /**
     * 权限认证
     */
    private Auth auth = new Auth();

    /**
     * 重试机制
     */
    public class Retry {
        /**
         * 最大超时时间
         */
        private int maxSleepTimeMs = 10000;
        /**
         * 基础超时时间
         */
        private int baseSleepTimeMs = 1000;
        /**
         * 最大重试次数
         */
        private int maxRetries = 3;

        public int getMaxSleepTimeMs() {
            return maxSleepTimeMs;
        }

        public void setMaxSleepTimeMs(int maxSleepTimeMs) {
            this.maxSleepTimeMs = maxSleepTimeMs;
        }

        public int getBaseSleepTimeMs() {
            return baseSleepTimeMs;
        }

        public void setBaseSleepTimeMs(int baseSleepTimeMs) {
            this.baseSleepTimeMs = baseSleepTimeMs;
        }

        public int getMaxRetries() {
            return maxRetries;
        }

        public void setMaxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
        }
    }

    /**
     * 权限认证
     */
    public class Auth {
        /**
         * 模式
         */
        private String scheme = "digest";
        /**
         * 凭证
         */
        private String auth;

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }
    }
}
