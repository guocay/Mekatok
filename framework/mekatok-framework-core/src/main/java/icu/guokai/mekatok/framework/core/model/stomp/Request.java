package icu.guokai.mekatok.framework.core.model.stomp;

import icu.guokai.mekatok.framework.core.model.Model;
import lombok.Data;

/**
 * stomp中的请求对象
 * @author GuoKai
 * @date 2021/8/24
 */
@Data
public class Request<T> implements Model {

    private static final long serialVersionUID = 6087673286430858763L;

    /**
     * 发送方
     */
    private String from;

    /**
     * 接收方
     */
    private String[] to;

    /**
     * 请求类型
     */
    private String type;

    /**
     * 请求数据体
     */
    private T data;

}
