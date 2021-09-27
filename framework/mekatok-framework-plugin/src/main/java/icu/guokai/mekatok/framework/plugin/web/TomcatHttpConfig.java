package icu.guokai.mekatok.framework.plugin.web;

import icu.guokai.mekatok.framework.core.constant.Global;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * 开启Tomcat双通道支持(http 和 https)
 * @author GuoKai
 * @date 2021/8/13
 */
@Configuration
@SuppressWarnings("all")
@DependsOn(Global.SPRING_UTIL_BEAN_NAME)
public class TomcatHttpConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        var tomcat = new TomcatServletWebServerFactory();
        // 添加http支持
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        var connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(Global.HTTP_PORT);
        return connector;
    }
}
