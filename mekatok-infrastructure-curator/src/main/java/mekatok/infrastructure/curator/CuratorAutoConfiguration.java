package mekatok.infrastructure.curator;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Curator 自动配置类
 * @author aCay
 * @since 2023.03.15
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CuratorProperties.class)
public class CuratorAutoConfiguration {
}
