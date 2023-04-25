package mekatok.application.event;

import java.util.HashMap;

/**
 * 事件上下文, 用于存放一些附属信息.
 * @author aCay
 * @since 2023.03.09
 */
public class EventContext extends HashMap<String, Object> {

    /**
     * 本次消费者 在Map中的key
     */
    public static final String CONSUMER_KEY = "consumer";

    /**
     * 写入 消费者标识
     * @param consumer 消费者标识
     */
    public void consumer(String consumer){
        put(CONSUMER_KEY, consumer);
    }

    /**
     * 获取 消费者
     * @return 消费者标识
     */
    public String consumer(){
        return (String) get(CONSUMER_KEY);
    }

}
