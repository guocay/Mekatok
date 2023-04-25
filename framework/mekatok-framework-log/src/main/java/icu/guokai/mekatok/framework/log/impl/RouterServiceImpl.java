package icu.guokai.mekatok.framework.log.impl;

import cn.hutool.json.JSONUtil;
import icu.guokai.mekatok.framework.core.message.Message;
import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import icu.guokai.mekatok.framework.log.service.IRouterService;
import icu.guokai.mekatok.framework.plugin.event.RouterCallAfter;
import icu.guokai.mekatok.framework.plugin.event.RouterCallBefore;
import icu.guokai.mekatok.framework.plugin.event.RouterCallMistake;
import icu.guokai.mekatok.framework.tool.servlet.ServletUtil;
import org.springframework.stereotype.Service;

/**
 * 路由类日志服务实现类
 * @author GuoKai
 * @date 2021/9/6
 */
@Service
public class RouterServiceImpl extends ServiceImpl implements IRouterService {

    @Override
    public void routerCallAfter(RouterCallAfter event) {
        var source = event.getMeta();
        log.info("Http 响应头内容为: {}", event.getHeaders().toString());
        if(source instanceof Message){
            log.info("Http 响应体内容为: {}", JSONUtil.toJsonStr(((Message<?>)source).getData()));
        }
    }

    @Override
    public void routerCallBefore(RouterCallBefore event) {
        var request = event.getMeta();
        log.info("Http 请求的类型为: {}; Http 请求的路径为: {}", request.getMethod(), request.getRequestURI());
        log.info("Http 请求头内容为: {}", JSONUtil.toJsonStr(ServletUtil.getHeaderMap(request)));
        log.info("Http 请求体内容为: {}", JSONUtil.toJsonStr(ServletUtil.getParamMap(request)));
    }

    @Override
    public void routerCallMistake(RouterCallMistake event) {
        var th = event.getMeta();
        log.error(th.getMessage(),th);
    }
}
