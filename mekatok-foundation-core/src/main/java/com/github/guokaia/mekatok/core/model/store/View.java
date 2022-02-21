package com.github.guokaia.mekatok.core.model.store;

import com.github.guokaia.mekatok.core.model.Packing;

/**
 * 数据库视图基类
 * @author GuoKai
 * @date 2022/1/27
 */
public interface View<T extends View<T>> extends Packing<T> {

}
