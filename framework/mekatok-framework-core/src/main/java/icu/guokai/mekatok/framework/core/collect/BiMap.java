package icu.guokai.mekatok.framework.core.collect;

import java.util.Map;

/**
 * 一个 key和value 均唯一的map
 * @author GuoKai
 * @date 2021/10/8
 */
public interface BiMap<K,V> extends Map<K,V> {

    /**
     * 用于反转 Map
     * @return 反转的Map
     */
    Map<V, K> inverse();

}
