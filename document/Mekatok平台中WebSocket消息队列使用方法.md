> WebSocket使得客户端和服务器之间的数据交换变得更加简单，允许服务端主动向客户端推送数据。在WebSocket API中，浏览器和服务器只需要完成一次握手，两者之间就可以创建持久性的连接，并进行双向数据传输。

早些时候,CS架构相较于BS架构最大的短板之一就是无法实现服务端至客户端的主动通信.基于Http协议 ***一次请求一次响应*** 的原则.使用Http协议实现的服务端主动请求基本均是以 客户端轮训 或 服务端阻塞 实现.

基于ws协议 和 stomp协议, spring-websocket 实现了一个自搭建的消息队列服务器. 连接进来的浏览器不仅可以接收服务端发送的消息,还可以像普通的生产者和消费者一样同级通讯.

### 准备工作

```xml
<dependency>
    <groupId>icu.guokai</groupId>
    <artifactId>mekatok-framework-stomp</artifactId>
</dependency>
```

### 连接与发送

1. 浏览器在登录后("/login"接口), 会返回一个JWT字符串.后续的认证会用到;
2. 浏览器主动连接通道,并通过第一步中的token作为凭证;

```javascript
// 基于 StompJS
const url = 'ws://127.0.0.1:727/mekatok/stomp'
const token = {
  'M-TOKEN': 'JWT String'
}
// 订阅自己的信道
const destination = '/user/websocket/chat'
let client = StompJs.Stomp.client(url)
client.connect(token, function(frame){
  client.subscribe(destination, function(message) {
  	console.log(message)
  })
})

// 发送消息
// 后台 一对多 中转路由
const channel = '/chat'
const req = {
  to: ['admin1'], // 接收方登录名数组
  from: 'admin', // 发送方登录名
  data: 'hello world', // 发送数据
  type: 'chat' // 数据包类型
}
client.send(channel, token, JSON.stringify(req))

// 发送消息
// 一对一发送
const username = 'admin1'
const _channel = '/user/${username}/websocket/chat'
client.send(_channel, token, JSON.stringify(req))
```

### 扩展内容

 ```java
 import icu.guokai.mekatok.framework.stomp.route.ChatRoomRouter;
 
 @MessageMapping("/chat")
 @SendToUser("/websocket/chat")
 public boolean sendMessageToSpecificClient(Principal principal, Request req);
 ```

后台 一对多 中转路由

```java
import icu.guokai.mekatok.framework.stomp.plugin.StompInterceptor;

// 消息接收后,处理前调用
@Override
public Message<?> preSend(Message<?> message, MessageChannel channel);
```

后台 连接事件 监控

