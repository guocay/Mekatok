package icu.guokai.mekatok.framework.core.liteflow;

import com.yomahub.liteflow.entity.data.LiteflowResponse;

/**
 * 流程编排 辅助类
 * 通过继承这个接口扩展类的能力
 * @author GuoKai
 * @date 2021/10/30
 */
public interface WithLiteFlow {
    /**
     * 执行 特定流程
     * @param chainId 流程 name
     * @param param solt 数据
     * @param slotIndex solt 索引
     * @param isInnerChain 是否包含
     * @param <T> solt类型
     * @return 运行后的solt数据
     */
    default <T extends Activity> T execute(String chainId, T param, Integer slotIndex, boolean isInnerChain){
        return LiteFlowCenter.execute(chainId, param, slotIndex, isInnerChain);
    }

    /**
     * 执行 特定流程
     * @param chainId 流程 name
     * @param param solt 数据
     * @param <T> solt类型
     * @return 运行后的solt数据
     */
    default <T extends Activity> T execute(String chainId, T param){
        return LiteFlowCenter.execute(chainId, param);
    }

    /**
     * 执行 特定流程
     * @param chainId 流程 name
     * @param param solt 数据
     * @param slotIndex solt 索引
     * @param isInnerChain 是否包含
     * @param <T> solt类型
     * @return 运行后的solt数据
     */
    default <T extends Activity> LiteflowResponse<T> execute2Resp(String chainId, T param,
                                                                        Integer slotIndex, boolean isInnerChain) {
        return LiteFlowCenter.execute2Resp(chainId, param, slotIndex, isInnerChain);
    }

    /**
     * 执行 特定流程
     * @param chainId 流程 name
     * @param param solt 数据
     * @param <T> solt类型
     * @return 运行后的solt数据
     */
    default  <T extends Activity> LiteflowResponse<T> execute2Resp(String chainId, T param){
        return LiteFlowCenter.execute2Resp(chainId, param);
    }

}
