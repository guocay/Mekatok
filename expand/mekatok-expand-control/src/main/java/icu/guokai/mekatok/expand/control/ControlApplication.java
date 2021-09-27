package icu.guokai.mekatok.expand.control;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Mekatok应用 - 健康监控台
 * @author GuoKai
 * @date 2021/8/4
 */
@EnableAdminServer
@SpringBootApplication
public class ControlApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class,args);
    }
}
