package com.github.guokaia.mekatok.webmvc.router;

import com.github.guokaia.mekatok.core.router.Router;
import com.github.guokaia.mekatok.webmvc.message.WebMvcConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 路由(Contorller) 的基类<br/>
 * 暴露一个 log对象
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public abstract class AbstractRouter implements Router, WebMvcConverter {

    /**
     * 日志对象
     */
    protected final Logger log = LoggerFactory.getLogger(getClass());


}
