package icu.guokai.mekatok.framework.core.route.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import icu.guokai.mekatok.framework.core.event.EventCenter;
import icu.guokai.mekatok.framework.core.message.support.WebMvcMessageSupport;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import icu.guokai.mekatok.framework.core.route.support.event.Commands;
import icu.guokai.mekatok.framework.core.route.support.event.DataCommandEvent;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * 平台内单表的删除操作扩展
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("unchecked")
public interface SimpleDeleteSupport <T extends Table<T>> extends WebMvcMessageSupport {

    /**
     * 删除单个元素,根据主键
     * @param id 主键
     * @return 操作成功
     */
    @DeleteMapping("/data/{id}")
    @ApiOperationSupport(order = Integer.MIN_VALUE + 1)
    @ApiOperation(value = "简单增删改查-删除",notes = "用于删除数据")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    default ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return script((() -> {
            var bean = creation(deleteBefore(id));
            var success = bean.delete();
            EventCenter.publish(new DataCommandEvent(bean, Commands.DELETE));
            return success;
        }));
    }

    /**
     * 删除的前置处理,用于实现类的重写
     * @param id 主键
     * @return 主键
     */
    default String deleteBefore(String id){
        return id;
    }

    /**
     * 构建当前对象实例
     * @param id 主键
     * @return 实例
     */
    @SuppressWarnings("all")
    private T creation(String id){
        // 获取当前接口的 实现类 在实现这个接口时所指定的泛型
        var first = Arrays.stream(getClass().getGenericInterfaces())
                .map(item -> ((ParameterizedType) item).getTypeName())
                .filter(item -> SimpleDeleteSupport.class.isAssignableFrom(ClassUtil.loadClass(item.substring(0,item.indexOf("<")))))
                .map(item -> ClassUtil.<T>loadClass(item.substring(item.indexOf("<") + 1,item.indexOf(">"))))
                .findFirst()
                .get();
        // 构建当前对象
        return (T) ReflectUtil.newInstance(first).setId(id);
    }
}
