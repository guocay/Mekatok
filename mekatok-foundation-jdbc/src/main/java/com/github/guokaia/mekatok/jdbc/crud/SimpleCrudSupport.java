package com.github.guokaia.mekatok.jdbc.crud;

import com.github.guokaia.mekatok.core.model.store.Table;

/**
 * 平台内单表的 增删改查 操作扩展
 * @author GuoKai
 * @date 2022/2/2
 */
public interface SimpleCrudSupport<T extends Table<T>> extends
    SimpleCreateSupport<T>, SimpleRetrieveSupport<T>, SimpleUpdateSupport<T>, SimpleDeleteSupport<T>{
}
