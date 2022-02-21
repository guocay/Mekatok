package com.github.guokaia.mekatok.common.handler;

import com.github.guokaia.mekatok.core.handler.IHadnler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 抽象实现类<br/>
 * 暴露一个 log对象
 * @author GuoKai
 * @date 2022/2/2
 */
public abstract class AbstractHandler implements IHadnler, InitializingBean {

    /**
     * 日志对象
     */
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
