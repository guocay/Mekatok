package icu.guokai.mekatok.framework.core.model.stomp;

import icu.guokai.mekatok.framework.core.model.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Stomp 中的响应对象
 * @author GuoKai
 * @date 2021/8/24
 */
@Accessors
@Data(staticConstructor = "of")
public class Response<T> implements Model {

    private static final long serialVersionUID = 1905471254458800862L;

    /**
     * 数据发送方
     */
    private String from;

    /**
     * 数据类型
     */
    private String type;

    /**
     * 返回数据
     */
    private T data;
}
