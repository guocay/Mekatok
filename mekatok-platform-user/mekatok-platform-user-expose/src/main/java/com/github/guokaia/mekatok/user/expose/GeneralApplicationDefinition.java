package com.github.guokaia.mekatok.user.expose;

import com.github.guokaia.mekatok.core.expose.ApplicationDefinition;

/**
 * 服务全局定义
 * @author GuoKai
 * @date 2022/2/6
 */
public class GeneralApplicationDefinition implements ApplicationDefinition {

    private GeneralApplicationDefinition(){}

    /**
     * 服务名称, 必须与yaml配置文件中的spring.application.name(就是在注册中心中的服务名)一致.<br/>
     * 因为,我们想在消费者端通过这个参数配置服务名,如在@FeignClient中.
     */
    public static final String SERVICE_NAME = "mekatok-platform-user";

}
