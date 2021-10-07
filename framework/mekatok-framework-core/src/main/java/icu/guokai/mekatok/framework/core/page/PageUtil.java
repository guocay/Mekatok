package icu.guokai.mekatok.framework.core.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.model.domain.View;
import icu.guokai.mekatok.framework.tool.servlet.ServletUtil;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用于获取分页信息的工具
 * @author GuoKai
 * @date 2021/8/13
 */
@SuppressWarnings("all")
public class PageUtil extends  cn.hutool.core.util.PageUtil {

    /**
     * 获取header中是否开启了分页
     * @return 是否分页
     */
    public static Boolean isPagination(){
        return Optional.ofNullable(ServletUtil.getHeaderWithBoolean(Global.IS_PAGINATION_MARK)).orElse(true);
    }

    /**
     * 从Request Header中取出pageSize和pageNum的值.构建Page对象.
     * -1 表示 不分页
     * @return 数组0位置为页号,数组1位置为每页大小.
     */
    public static <T extends View> IPage<T> buildPageInfo(){
        var page = new Page<T>(Optional.ofNullable(ServletUtil.getHeaderWithLong(Global.PAGE_CURRENT_MARK)).orElse(1L),
                Optional.ofNullable(ServletUtil.getHeaderWithLong(Global.PAGE_SIZE_MARK)).orElse(Global.DEFAULT_PAGE_SIZE));
        if (!isPagination()){
            page.setSize(-1);
        }
        return page;
    }

    /**
     * 将页数和每页条目数转换为开始位置<br>
     * 此方法用于不包括结束位置的分页方法<br>
     * 例如：
     *
     * <pre>
     * 页码：0，每页10 =》 0
     * 页码：1，每页10 =》 10
     * ……
     * </pre>
     *
     * <p>
     * 当{@link #setFirstPageNo(int)}设置为1时：
     * <pre>
     * 页码：1，每页10 =》 0
     * 页码：2，每页10 =》 10
     * ……
     * </pre>
     *
     * @param pageNo   页码（从0计数）
     * @param pageSize 每页条目数
     * @return 开始位置
     */
    public static Integer getStart(Long pageNo, Long pageSize) {
        setFirstPageNo(1);
        return getStart(pageNo.intValue(),pageSize.intValue());
    }

    /**
     * 将页数和每页条目数转换为结束位置<br>
     * 此方法用于不包括结束位置的分页方法<br>
     * 例如：
     *
     * <pre>
     * 页码：0，每页10 =》 9
     * 页码：1，每页10 =》 19
     * ……
     * </pre>
     *
     * <p>
     * 当{@link #setFirstPageNo(int)}设置为1时：
     * <pre>
     * 页码：1，每页10 =》 9
     * 页码：2，每页10 =》 19
     * ……
     * </pre>
     *
     * @param pageNo   页码（从0计数）
     * @param pageSize 每页条目数
     * @return 开始位置
     * @since 5.2.5
     */
    public static Integer getEnd(Long pageNo, Long pageSize) {
        setFirstPageNo(1);
        return getEnd(pageNo.intValue(),pageSize.intValue());
    }

    /**
     * 分页对象重排
     * @param page 原分页对象
     * @param mapper 转换逻辑
     * @param <T> 需要转换成的对象
     * @param <F> 原分页对象实体类型
     * @return 重加载的分页
     */
    public static <T,F> IPage<T> reBuild(IPage<F> page, Function<? super F, ? extends T> mapper){
        var buildPage = new Page<T>(page.getCurrent(),page.getSize(), page.getTotal());
        buildPage.setRecords(page.getRecords().stream().map(mapper).collect(Collectors.toList()));
        return buildPage;
    }

}
