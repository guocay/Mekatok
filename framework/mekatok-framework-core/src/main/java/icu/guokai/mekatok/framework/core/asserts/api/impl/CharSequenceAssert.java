package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.util.StrUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class CharSequenceAssert extends Assert<CharSequenceAssert, CharSequence> {
    /**
     * 构造器
     * @param actual 待断言对象
     */
    public CharSequenceAssert(CharSequence actual) {
        super(actual);
    }

    @Override
    public CharSequenceAssert is(CharSequence obj) {
        return exception(actual.equals(obj));
    }

    /**
     * <p>字符串是空白，空白的定义如下：</p>
     * <ol>
     *     <li>{@code null}</li>
     *     <li>空字符串：{@code ""}</li>
     *     <li>空格、全角空格、制表符、换行符，等不可见字符</li>
     * </ol>
     *
     * <p>例：</p>
     * <ul>
     *     <li>{@code StrUtil.isBlank(null)     // true}</li>
     *     <li>{@code StrUtil.isBlank("")       // true}</li>
     *     <li>{@code StrUtil.isBlank(" \t\n")  // true}</li>
     *     <li>{@code StrUtil.isBlank("abc")    // false}</li>
     * </ul>
     * @return 断言工具
     */
    public CharSequenceAssert isBlank(){
        return exception(StrUtil.isBlank(actual));
    }

    /**
     * 字符串不是空白
     * @return 断言工具
     */
    public CharSequenceAssert isNotBlank(){
        return exception(StrUtil.isNotBlank(actual));
    }

    /**
     * <p>字符串是空，空的定义如下：</p>
     * <ol>
     *     <li>{@code null}</li>
     *     <li>空字符串：{@code ""}</li>
     * </ol>
     *
     * <p>例：</p>
     * <ul>
     *     <li>{@code StrUtil.isEmpty(null)     // true}</li>
     *     <li>{@code StrUtil.isEmpty("")       // true}</li>
     *     <li>{@code StrUtil.isEmpty(" \t\n")  // false}</li>
     *     <li>{@code StrUtil.isEmpty("abc")    // false}</li>
     * </ul>
     * @return 断言工具
     */
    public CharSequenceAssert isEmpty(){
        return exception(StrUtil.isEmpty(actual));
    }

    /**
     * 字符串不是空
     * @return 断言工具
     */
    public CharSequenceAssert isNotEmpty(){
        return exception(StrUtil.isNotEmpty(actual));
    }

    /**
     * 包含
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert contains(CharSequence obj){
        return exception(StrUtil.contains(actual, obj));
    }


    /**
     * 任意 包含
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert containsAny(CharSequence... obj){
        return exception(StrUtil.containsAny(actual, obj));
    }

    /**
     * 包含 空白
     * @return 断言工具
     */
    public CharSequenceAssert containsBlank(){
        return exception(StrUtil.containsBlank(actual));
    }

    /**
     * 包含 不区分大小写
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert containsIgnoreCase(CharSequence obj){
        return exception(StrUtil.containsIgnoreCase(actual, obj));
    }

    /**
     * 检查指定字符串中是否只包含给定的字符
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert containsOnly(char... obj){
        return exception(StrUtil.containsOnly(actual, obj));
    }

    /**
     * 是否以指定字符串结尾
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert endWith(CharSequence obj){
        return exception(StrUtil.endWith(actual, obj));
    }

    /**
     * 是否以指定字符串结尾
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert endWithAny(CharSequence... obj){
        return exception(StrUtil.endWithAny(actual, obj));
    }

    /**
     * 是否以指定字符串结尾 - 忽略大小写
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert endWithIgnoreCase(CharSequence obj){
        return exception(StrUtil.endWithIgnoreCase(actual, obj));
    }

    /**
     * 是否以指定字符串开始
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert startWith(CharSequence obj){
        return exception(StrUtil.startWith(actual, obj));
    }

    /**
     * 是否以指定字符串开始
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert startWithAny(CharSequence... obj){
        return exception(StrUtil.startWithAny(actual, obj));
    }

    /**
     * 是否以指定字符串开始 - 忽略大小写
     * @param obj 被包含的字符
     * @return 断言工具
     */
    public CharSequenceAssert startWithIgnoreCase(CharSequence obj){
        return exception(StrUtil.startWithIgnoreCase(actual, obj));
    }

    /**
     * 字符串长度等于
     * @param count 长度
     * @return 断言工具
     */
    public CharSequenceAssert count(Integer count){
        return exception(actual.length() == count);
    }

    /**
     * 字符串长度小于
     * @param lt 长度
     * @return 断言工具
     */
    public CharSequenceAssert lt(Integer lt){
        return exception(actual.length() < lt);
    }

    /**
     * 字符串长度小于
     * @param le 长度
     * @return 断言工具
     */
    public CharSequenceAssert le(Integer le){
        return exception(actual.length() <= le);
    }

    /**
     * 字符串长度大于
     * @param gt 长度
     * @return 断言工具
     */
    public CharSequenceAssert gt(Integer gt){
        return exception(actual.length() > gt);
    }

    /**
     * 字符串长度大于等于
     * @param ge 长度
     * @return 断言工具
     */
    public CharSequenceAssert ge(Integer ge){
        return exception(actual.length() >= ge);
    }

    /**
     * 字符串长度不等于
     * @param ne 长度
     * @return 断言工具
     */
    public CharSequenceAssert ne(Integer ne){
        return exception(actual.length() != ne);
    }

    /**
     * 字符串下标是否是
     * @param index 字符串下标
     * @param c 字符
     * @return 断言工具
     */
    public CharSequenceAssert charAt(Integer index, char c){
        return exception(actual.charAt(index) == c);
    }

}
