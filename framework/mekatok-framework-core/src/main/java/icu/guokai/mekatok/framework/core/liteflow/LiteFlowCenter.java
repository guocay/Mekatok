package icu.guokai.mekatok.framework.core.liteflow;

import cn.hutool.extra.spring.SpringUtil;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.entity.data.LiteflowResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * LiteFlow 使用中心
 * @author GuoKai
 * @date 2021/10/30
 */
@Slf4j
@SuppressWarnings("all")
public abstract class LiteFlowCenter {

    /**
     * 获取 流程 启动器
     * @return FlowExecutor
     */
    private static FlowExecutor executor(){
        return SpringUtil.getBean(FlowExecutor.class);
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
    public static <T extends Activity> T execute(String chainId, T param, Integer slotIndex, boolean isInnerChain) {
        try {
            return executor().execute(chainId,param,(Class<T>) param.getClass(),slotIndex,isInnerChain);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new LiteFlowException(e);
        }
    }

    /**
     * 执行 特定流程
     * @param chainId 流程 name
     * @param param solt 数据
     * @param <T> solt类型
     * @return 运行后的solt数据
     */
    public static <T extends Activity> T execute(String chainId, T param){
        return execute(chainId, param, null, false);
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
    public static <T extends Activity> LiteflowResponse<T> execute2Resp(String chainId, T param,
                                                                        Integer slotIndex, boolean isInnerChain) {
        try {
            return executor().execute2Resp(chainId,param,(Class<T>) param.getClass(),slotIndex,isInnerChain);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new LiteFlowException(e);
        }
    }

    /**
     * 执行 特定流程
     * @param chainId 流程 name
     * @param param solt 数据
     * @param <T> solt类型
     * @return 运行后的solt数据
     */
    public static <T extends Activity> LiteflowResponse<T> execute2Resp(String chainId, T param){
        return execute2Resp(chainId, param, null, false);
    }

}
