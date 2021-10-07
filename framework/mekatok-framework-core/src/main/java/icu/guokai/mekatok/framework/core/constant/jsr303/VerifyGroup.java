package icu.guokai.mekatok.framework.core.constant.jsr303;

/**
 * 用于字段校验的分组标识
 * @author GuoKai
 * @date 2021/8/5
 */
@SuppressWarnings("all")
public abstract class VerifyGroup {

    /** 用于标注添加的分组 */
    public interface ADD{}

    /** 用于标注查询的分组 */
    public interface QUERY{}

    /** 用于标注删除的分组 */
    public interface DELETE{}

    /** 用于标注更新的分组 */
    public interface UPDATE{}

    /** 自定义校验组标识1 */
    public interface CUSTOM1{}

    /** 自定义校验组标识2 */
    public interface CUSTOM2{}

    /** 自定义校验组标识3 */
    public interface CUSTOM3{}
}
