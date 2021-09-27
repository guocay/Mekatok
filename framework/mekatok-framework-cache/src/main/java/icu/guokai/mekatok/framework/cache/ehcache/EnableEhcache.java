package icu.guokai.mekatok.framework.cache.ehcache;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 ehcache 缓存配置
 * @author GuoKai
 * @date 2021/8/23
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EhCacheConfig.class)
public @interface EnableEhcache {
}
