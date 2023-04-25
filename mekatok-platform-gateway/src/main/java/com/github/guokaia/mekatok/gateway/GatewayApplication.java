package com.github.guokaia.mekatok.gateway;

import com.github.guokaia.mekatok.context.MekatokApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * Gateway 网关应用
 * @author GuoKai
 */
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        MekatokApplication.run(GatewayApplication.class, args);
    }
}
