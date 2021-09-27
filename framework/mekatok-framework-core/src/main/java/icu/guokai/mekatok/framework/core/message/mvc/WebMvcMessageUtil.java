package icu.guokai.mekatok.framework.core.message.mvc;

import cn.hutool.core.util.ObjectUtil;
import icu.guokai.mekatok.framework.core.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("rawtypes")
public abstract class WebMvcMessageUtil {

    /**
     * 默认状态使用的消息对象
     */
    private final static Message MESSAGE = Message.of();

    /**
     * 消息回执
     * @param status http状态
     * @param <T> 泛型
     * @return 返回消息
     */
    public static <T> ResponseEntity receipt(HttpStatus status){
        return receipt(null, status);
    }

    /**
     * 消息回执
     * @param body http消息体
     * @param <T> 泛型
     * @return 返回消息
     */
    public static <T> ResponseEntity receipt(T body){
        return receipt(body, HttpStatus.OK);
    }

    /**
     * 消息回执
     * @param body http消息体
     * @param status http状态
     * @param <T> 泛型
     * @return 返回消息
     */
    public static <T> ResponseEntity receipt(T body, HttpStatus status){
        return receipt(body,null, status);
    }

    /**
     * 消息回执
     * @param body http消息体
     * @param headers http消息头
     * @param status http状态
     * @param <T> 泛型
     * @return 返回消息
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseEntity receipt(T body, MultiValueMap<String, String> headers, HttpStatus status){
        if(ObjectUtil.isNull(body)){
            body = (T) MESSAGE.clone();
        }
        return new ResponseEntity<T>(body, headers, status);
    }

}
