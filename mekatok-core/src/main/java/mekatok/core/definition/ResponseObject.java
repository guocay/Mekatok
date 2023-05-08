package mekatok.core.definition;

/**
 * 响应对象
 * @author GuoCay
 * @since 2023/3/6
 */
public interface ResponseObject extends Definition{

    /**
     * 获取请求序号
     * @return 请求序号
     */
    Long getRequestId();

    /**
     * 获取是否成功
     * @return 是否成功
     */
    Boolean getSuccess();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getMistake();

}
