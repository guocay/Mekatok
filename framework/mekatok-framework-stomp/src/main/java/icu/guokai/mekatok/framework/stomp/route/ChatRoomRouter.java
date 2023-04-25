package icu.guokai.mekatok.framework.stomp.route;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.model.stomp.Request;
import icu.guokai.mekatok.framework.core.model.stomp.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;

/**
 * web socket 相关路由
 * 连接地址: ws://127.0.0.1:727/mekatok/stomp
 * 订阅通道: /p2p/websocket/chat
 * 推送通道: /chat
 * @author GuoKai
 * @date 2021/8/24
 */
@RestController
@SuppressWarnings("all")
@Api(tags = "WebSocket相关接口")
@ApiSupport(author = Global.GK)
public class ChatRoomRouter {

    @Autowired
    private SimpMessagingTemplate template;

    private static final String STOMP_MESSAGE_TYPE = "chat";

    /**
     * 一对多通讯
     * @param req 请求对象
     */
    @MessageMapping(Global.STOMP_CHAT_CHANNEL)
    @SendToUser(Global.MESSAGE_PATH + Global.STOMP_CHAT_CHANNEL)
    public boolean sendMessageToSpecificClient(Principal principal, Request req) {
        var res = Response.of().setFrom(principal.getName())
                .setType(STOMP_MESSAGE_TYPE).setData(req.getData());
        Arrays.stream(req.getTo()).forEach(item -> template.convertAndSendToUser(item,
                 Global.MESSAGE_PATH + Global.STOMP_CHAT_CHANNEL, res));
        return true;
    }
}
