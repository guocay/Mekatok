package icu.guokai.mekatok.framework.plugin.verify;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.system.oshi.OshiUtil;
import icu.guokai.mekatok.framework.plugin.verify.property.Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 应用启动时的监听
 * 用于在 ApplicationPreparedEvent 时,
 * 校验是否是允许启动的主机序列号
 * @author GuoKai
 * @date 2021/8/31
 */
@Slf4j
@SuppressWarnings("all")
public class AppStartUpVerify implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private Property property;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        if(!property.getEnable()){
            log.warn("未启动验证BIOS序列号功能,服务继续正常启动...");
            return;
        }

        if(!ArrayUtil.contains(property.getServerSerial(), OshiUtil.getSystem().getSerialNumber())){
            log.error("验证BIOS序列号失败,服务无法正常启动...");
            System.exit(0);
        }
        log.info("验证BIOS序列号完成,服务继续正常启动...");
    }
}
