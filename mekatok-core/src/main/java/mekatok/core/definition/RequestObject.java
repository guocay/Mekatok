package mekatok.core.definition;

/**
 * 请求对象
 * @author GuoCay
 * @since 2023/3/6
 */
public interface RequestObject extends Definition{

    /**
     * 获取调用方
     * @return 调用方ID
     */
    Long getCallerId();

    /**
     * 获取请求ID(目前用于幂等)
     * @return 请求ID
     */
    Long getRequestId();
}
