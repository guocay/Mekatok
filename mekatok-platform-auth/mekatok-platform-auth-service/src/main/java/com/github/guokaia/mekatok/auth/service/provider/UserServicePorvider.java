package com.github.guokaia.mekatok.auth.service.provider;

import com.github.guokaia.mekatok.user.expose.GeneralApplicationDefinition;
import com.github.guokaia.mekatok.user.expose.function.UserAppServiceDefinition;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户服务 提供者
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/7
 */
@FeignClient(GeneralApplicationDefinition.SERVICE_NAME)
public interface UserServicePorvider extends UserAppServiceDefinition {
}
