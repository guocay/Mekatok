package com.github.guokaia.mekatok.actuator;

import com.github.guokaia.mekatok.context.MekatokApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Admin 启动程序
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/31
 */
@EnableAdminServer
@SpringBootApplication
public class ActuatorApplication {
    public static void main(String[] args) {
        MekatokApplication.run(ActuatorApplication.class, args);
    }
}
