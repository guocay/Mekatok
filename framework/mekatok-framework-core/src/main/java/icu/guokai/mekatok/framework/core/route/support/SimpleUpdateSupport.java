package icu.guokai.mekatok.framework.core.route.support;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import icu.guokai.mekatok.framework.core.constant.jsr303.VerifyGroup;
import icu.guokai.mekatok.framework.core.event.EventCenter;
import icu.guokai.mekatok.framework.core.message.support.WebMvcMessageSupport;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import icu.guokai.mekatok.framework.core.route.support.event.Commands;
import icu.guokai.mekatok.framework.core.route.support.event.DataCommandEvent;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * 平台内单表的删除操作扩展
 * @author GuoKai
 * @date 2021/8/5
 */
public interface SimpleUpdateSupport <T extends Table<T>> extends WebMvcMessageSupport {

    /**
     * 更新默认元素,通过主键
     * @param bean 对象(必须包含主键)
     * @return 操作成功
     */
    @PutMapping
    @SuppressWarnings("unchecked")
    @ApiOperationSupport(order = Integer.MIN_VALUE + 3)
    @ApiOperation(value = "简单增删改查-更新",notes = "用于更新数据")
    default ResponseEntity<Boolean> update(@Validated(VerifyGroup.UPDATE.class) T bean){
        return script((() -> {
            updateBefore(bean).update();
            EventCenter.publish(new DataCommandEvent(bean, Commands.UPDATE));
            return bean;
        }));
    }

    /**
     * 更新的前置处理,用于实现类的重写
     * @param bean 更新对象
     * @return 更新对象
     */
    default T updateBefore(T bean){
        return bean;
    }
}
