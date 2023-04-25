package mekatok.adapter.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring MVC 自动配置类
 * @author aCay
 * @since 2023.03.09
 */
@Configuration
@Import({SpringWebRestControllerAdvice.class})
public class SpringWebAutoConfiguration {
}
