package mekatok.adapter.web.validator;

/**
 * 用于字段校验的分组标识
 * @author aCay
 * @since 2023.03.11
 */
interface ValidatorTag {

    /** 用于标注添加的分组 */
    interface ADD{}

    /** 用于标注查询的分组 */
    interface QUERY{}

    /** 用于标注删除的分组 */
    interface DELETE{}

    /** 用于标注更新的分组 */
    interface UPDATE{}

    /** 自定义校验组标识1 */
    interface CUSTOM1{}

    /** 自定义校验组标识2 */
    interface CUSTOM2{}

    /** 自定义校验组标识3 */
    interface CUSTOM3{}
}
