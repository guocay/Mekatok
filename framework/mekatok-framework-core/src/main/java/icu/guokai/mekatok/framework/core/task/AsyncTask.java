package icu.guokai.mekatok.framework.core.task;

/**
 * 用于定义执行接口
 * @author GuoKai
 * @date 2021/8/31
 */
@FunctionalInterface
public interface AsyncTask extends Runnable{

    /**
     * 异步执行启动延迟
     * @return 默认返回 0
     */
    default Long startTimeout(){
        return 0L;
    }

}
