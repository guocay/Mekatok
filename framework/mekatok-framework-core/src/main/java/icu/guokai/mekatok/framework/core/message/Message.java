package icu.guokai.mekatok.framework.core.message;

import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 平台内消息的基类
 * @author GuoKai
 * @date 2021/8/5
 */
@Data
@Accessors
@ApiModel("消息对象")
@SuppressWarnings("all")
public class Message<T> implements Cloneable{

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("提示")
    private String tips;

    @ApiModelProperty("时间戳")
    private LocalDateTime timestamp;

    @ApiModelProperty("操作成败")
    private Boolean success;

    /**
     * 设置默认值
     * @return MekatokMessage对象
     */
    public Message<T> defaults(){
        return setSuccess(true).setTimestamp(LocalDateTime.now()).setTips("");
    }

    /**
     * 创建对象,并初始化
     * @param <T> 泛型
     * @return 消息对象
     */
    public static <T> Message<T> of() {
        return new Message<T>().defaults();
    }

    @Override
    public Message<T> clone(){
        try {
            var message = (Message<T>) super.clone();
            return message.setTimestamp(LocalDateTime.now());
        } catch (CloneNotSupportedException e) {
            throw new MekatokException("",e);
        }
    }

}
