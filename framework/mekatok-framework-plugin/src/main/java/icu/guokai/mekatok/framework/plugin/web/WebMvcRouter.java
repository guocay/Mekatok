package icu.guokai.mekatok.framework.plugin.web;

import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.plugin.mistake.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * 用于定义 401 403 404 的消息转换
 * @author GuoKai
 * @date 2021/8/17
 */
@RestController
public class WebMvcRouter extends Router {

    /**
     * 定义默认的异常返回消息体
     */
    private static final NotFoundException NOT_FOUND = new NotFoundException("This interface is lost");

    /**
     * 转发'404'状态码
     * 这个接口走丢了
     * @return 返回对象
     */
    @ApiIgnore
    @RequestMapping("/" + HttpServletResponse.SC_NOT_FOUND)
    public ResponseEntity<String> unFound(){
        return failure(NOT_FOUND);
    }

}
