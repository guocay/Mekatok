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
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 平台内单表的增加操作扩展
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("all")
public interface SimpleCreateSupport <T extends Table<T>> extends WebMvcMessageSupport {

    /**
     * 默认的添加方法
     * @param bean 表单对象
     * @return 返回操作成功
     */
    @PostMapping
    @ApiOperationSupport(order = Integer.MIN_VALUE)
    @ApiOperation(value = "简单增删改查-添加",notes = "用于添加数据")
    default ResponseEntity<T> insert(@Validated(VerifyGroup.ADD.class) T bean){
        return script(() -> {
            insertBefore(bean).insert();
            EventCenter.publish(new DataCommandEvent(bean, Commands.INSERT));
            return bean;
        });
    }

    /**
     * 新增函数的前置处理,用于实现类重写
     * @param bean 新增对象
     * @return 新增对象
     */
    default T insertBefore(T bean){
        return bean;
    }

}
