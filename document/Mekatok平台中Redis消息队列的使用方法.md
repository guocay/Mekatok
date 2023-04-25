1. 引入 mekatok-framework-mq 模块;
2. 在启动类上加入 @EnableRidesMq 注解;
3. 声明一个实现了 icu.guokai.mekatok.framework.mq.redis.deploy.RedisMqListener 接口的类并交由Spring bean容器管理;
```
    @Bean
    public RedisMqConfiguration redisMqConfiguration(){
        return new RedisMqConfiguration() {
            @Override
            public String channel() {
                return "channel";
            }
            @Override
            public MessageListener receiver() {
                return (message,pattern) -> System.out.println(new String(pattern) + ":" + message);
            }

        };
    }
```
其中,channel代表订阅的通道,receiver表示响应函数(推荐使用Lambda表达式实现,其中 message对象代表接收到的消息,pattern表示通道名)

消息发送可以通过icu.guokai.mekatok.framework.mq.MqCenter.convertAndSend(channel, message)函数,向通道发送消息.



### 准备

```xml
<!-- 引入队列模块 -->
<dependency>
  <groupId>icu.guokai</groupId>
  <artifactId>mekatok-framework-queue</artifactId>
</dependency>
```

```java
/**
 * 添加注解 EnableRidesMq 开启消息队列
 */
@EnableRidesMq
public class Application(){
  public static void main(String[] args){
    SpringApplication.run(Application.class, args);
  }
}
```

### 使用

```java
// 向指定信道发送消息
import icu.guokai.mekatok.framework.mq.MqCenter;

MqCenter.convertAndSend("channel-name", "hello everyone");

```

```java
// 监听信道
import icu.guokai.mekatok.framework.mq.redis.deploy.RedisMqListener;
import org.springframework.data.redis.connection.MessageListener;

@Component
public class CustomRedisMqListener implements RedisMqListener {
    // 设置信道名称
    @Override
    public String channel() {
      return "channel-name";
    }
  	// 设置处理类
    @Override
    public MessageListener receiver() {
      return (message,pattern) -> System.out.println(new String(pattern) + ":" + message);
    }
}
```

