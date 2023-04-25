package icu.guokai.mekatok.framework.security.configure.oauth;

import icu.guokai.mekatok.framework.security.plugin.SecurityAuthenticationHandler;
import icu.guokai.mekatok.framework.security.plugin.SecurityAuthenticationProvider;
import icu.guokai.mekatok.framework.security.property.Property;
import icu.guokai.mekatok.framework.security.route.OauthSecurityRouter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author GuoKai
 * @date 2021/8/18
 */
@Configuration
@SuppressWarnings("all")
@Import({Property.class, SecurityAuthenticationProvider.class, SecurityAuthenticationHandler.class, OauthSecurityRouter.class})
public class OauthSecurityConfiguration {

}
