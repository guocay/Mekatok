package icu.guokai.mekatok.framework.core.route.support;

import icu.guokai.mekatok.framework.core.model.domain.Table;

/**
 * 平台内单表的 增删改查 操作扩展
 * @author GuoKai
 * @date 2021/8/5
 */
public interface SimpleCrudSupport <T extends Table<T>>
        extends SimpleCreateSupport<T>,SimpleRetrieveSupport<T>,SimpleUpdateSupport<T>,SimpleDeleteSupport<T> {
}
