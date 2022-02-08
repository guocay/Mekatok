package com.github.guokaia.mekatok.gateway.swagger.router;

import com.github.guokaia.mekatok.gateway.swagger.config.SwaggerResourcesProviderImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.util.List;

/**
 * 用于定义 Swagger资源 的映射器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/1/31
 */
@RestController
public class SwaggerRouter {

    private final SecurityConfiguration securityConfiguration;

    private final UiConfiguration uiConfiguration;

    private final SwaggerResourcesProviderImpl swaggerConfig;

    public SwaggerRouter(SecurityConfiguration securityConfiguration,
                         UiConfiguration uiConfiguration,
                         SwaggerResourcesProviderImpl swaggerConfig) {
        this.securityConfiguration = securityConfiguration;
        this.uiConfiguration = uiConfiguration;
        this.swaggerConfig = swaggerConfig;
    }

    @GetMapping("/swagger-resources/configuration/security")
    public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
        return Mono.just(new ResponseEntity<SecurityConfiguration>(securityConfiguration, HttpStatus.OK));
    }

    @GetMapping("/swagger-resources/configuration/ui")
    public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
        return Mono.just(new ResponseEntity<UiConfiguration>(uiConfiguration, HttpStatus.OK));
    }

    @GetMapping("/swagger-resources")
    public Mono<ResponseEntity<List<SwaggerResource>>> swaggerResources() {
        return Mono.just((new ResponseEntity<List<SwaggerResource>>(swaggerConfig.get(), HttpStatus.OK)));
    }

}
