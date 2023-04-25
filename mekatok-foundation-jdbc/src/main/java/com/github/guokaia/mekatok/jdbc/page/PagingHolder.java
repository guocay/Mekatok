package com.github.guokaia.mekatok.jdbc.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.core.model.Packing;
import com.github.guokaia.mekatok.webmvc.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 用于获取分页信息的静态工具类
 * @author GuoKai
 * @date 2022/2/2
 */
@SuppressWarnings("all")
@Component
public class PagingHolder {

    private PagingHolder(){}

    private static PageProperties properties;

    @Autowired
    public void setProperties(PageProperties properties) {
        PagingHolder.properties = properties;
    }

    /**
     * 获取header中是否开启了分页
     * @return 是否分页
     */
    public static Boolean isPaging(){
        Optional<Boolean> isPagination =
            Optional.ofNullable(ServletHolder.getHeaderWithBoolean(Global.IS_PAGINATION_MARK));
        return isPagination.orElse(true);
    }

    /**
     * 从Request Header中取出pageSize和pageNum的值.构建Page对象.
     * -1 表示 不分页
     * @param <T> 泛型
     * @return 数组0位置为页号,数组1位置为每页大小.
     */
    public static <T extends Packing<T>> IPage<T> page(){
        IPage<T> page = new Page<T>(
            Optional.ofNullable(ServletHolder.getHeaderWithLong(Global.PAGE_CURRENT_MARK)).orElse(1L),
            Optional.ofNullable(ServletHolder.getHeaderWithLong(Global.PAGE_SIZE_MARK)).orElse(properties.getSize())
        );
        if (!isPaging()){
            page.setSize(-1);
        }
        return page;
    }

    /**
     * 将 {@link com.baomidou.mybatisplus.core.metadata.IPage} 转换为 {@link com.github.guokaia.mekatok.core.model.Paging}
     * @param page 查询后的分页对象
     * @param <T> 泛型
     * @return 转换后的传输容器对象
     */
    public static <T extends Packing<T>> GeneralPaging<T> build(IPage<T> page){
        return GeneralPaging.of(page.getRecords(), page.getTotal(), page.getSize(), page.getCurrent());
    }

}
