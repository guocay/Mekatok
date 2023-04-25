package com.github.guokaia.mekatok.gateway.service.provider;

import com.github.guokaia.mekatok.auth.expose.function.AuthAppServiceDefinition;
import org.springframework.cloud.openfeign.FeignClient;

import static com.github.guokaia.mekatok.auth.expose.GeneralApplicationDefinition.SERVICE_NAME;

/**
 * 认证服务提供方
 * @author GuoKai
 * @date 2022/2/8
 */
@FeignClient(SERVICE_NAME)
public interface AuthServiceProdiver extends AuthAppServiceDefinition {
}
