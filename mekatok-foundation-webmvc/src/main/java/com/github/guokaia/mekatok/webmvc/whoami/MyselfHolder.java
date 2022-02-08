package com.github.guokaia.mekatok.webmvc.whoami;

/**
 * 用于在当前线程中存储用户标识<br/>
 * PS: 一定要在请求的同一线程中获取,否则取不到哦.
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/3
 */
public class MyselfHolder {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取当前线程中的用户标识(用户ID)
     * @return 用户标识
     */
    public static String get(){
        return THREAD_LOCAL.get();
    }

    /**
     * 将数据加载到当前线程中
     * @param current 用户标识
     */
    protected static void load(String current){
        THREAD_LOCAL.set(current);
    }

    /**
     * 清空线程内对象
     */
    protected static void remove(){
        THREAD_LOCAL.remove();
    }
    
}
