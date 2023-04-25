package com.github.guokaia.mekatok.notice.service.router;

import com.github.guokaia.mekatok.common.Global;
import io.swagger.annotations.Api;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 *  web socket 相关路由
 *  连接地址: ws://ip:port/stomp
 *  订阅通道: /user/websocket/chat
 *  推送通道: /chat
 * @author GuoKai
 * @date 2022/2/5
 */
@RestController
@Api(tags = "WebSocket相关接口")
public class ChatRoomRouter {

    private final SimpMessagingTemplate template;

    private static final String STOMP_MESSAGE_TYPE = "chat";

    public ChatRoomRouter(SimpMessagingTemplate template) {
        this.template = template;
    }

    /**
     * 一对多通讯
     */
    @MessageMapping(Global.WEBSOCKET_STOMP_CHAT_CHANNEL)
    @SendToUser(Global.WEBSOCKET_MESSAGE_PATH + Global.WEBSOCKET_STOMP_CHAT_CHANNEL)
    public Boolean sendMessageToSpecificClient(Principal principal, String message) {
        // todo 这里的消息是发不了的, 因为未指定user属性[arg0].
        template.convertAndSendToUser("","",message);
        return Boolean.TRUE;
    }

}
