package icu.guokai.mekatok.framework.core.route.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import icu.guokai.mekatok.framework.core.constant.jsr303.VerifyGroup;
import icu.guokai.mekatok.framework.core.message.support.WebMvcMessageSupport;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 平台内单表的查询操作扩展
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("all")
public interface SimpleRetrieveSupport<T extends Table<T>> extends WebMvcMessageSupport {

    /**
     * 默认的查询单个对象函数
     * @param id 对象主键
     * @return 对象数据
     */
    @GetMapping("/data/{id}")
    @ApiOperationSupport(order = Integer.MIN_VALUE + 4)
    @ApiOperation(value = "简单增删改查-详情",notes = "用于查询数据通过ID")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    default ResponseEntity<T> detail(@PathVariable("id") String id){
        return success(queryAfter(creation(id).detail()));
    }

    /**
     * 根据查询条件 查询分页数据
     * @param bean 对象查询条件
     * @return 对象数据
     */
    @GetMapping("/page")
    @ApiOperationSupport(order = Integer.MIN_VALUE+4)
    @ApiOperation(value = "简单增删改查-分页",notes = "用于查询数据通过分页")
    default ResponseEntity<List<T>> page(@Validated(VerifyGroup.QUERY.class) T bean){
        var page = bean.selectPage();
        page.setRecords(forEach(page.getRecords()));
        return script(() -> page);
    }

    /**
     * 查询的前置处理,用于实现类的重写
     * @param bean 查询对象
     * @return 查询对象
     */
    default T queryAfter(T bean){
        return bean;
    }

    /**
     * 循环处理返回数据
     * @param list 返回的数据
     * @return 返回的数据
     */
    private List<T> forEach(List<T> list){
        return list.stream().map(this::queryAfter).collect(Collectors.toList());
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
                .filter(item -> SimpleRetrieveSupport.class.isAssignableFrom(ClassUtil.loadClass(item.substring(0,item.indexOf("<")))))
                .map(item -> ClassUtil.<T>loadClass(item.substring(item.indexOf("<") + 1,item.indexOf(">"))))
                .findFirst()
                .get();
        // 构建当前对象
        return (T) ReflectUtil.newInstance(first).setId(id);
    }
}
