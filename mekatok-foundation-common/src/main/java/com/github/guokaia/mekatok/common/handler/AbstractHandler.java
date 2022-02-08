package com.github.guokaia.mekatok.common.handler;

import com.github.guokaia.mekatok.core.handler.IHadnler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象实现类<br/>
 * 暴露一个 log对象
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public abstract class AbstractHandler implements IHadnler {

    /**
     * 日志对象
     */
    protected final Logger log = LoggerFactory.getLogger(getClass());

}
