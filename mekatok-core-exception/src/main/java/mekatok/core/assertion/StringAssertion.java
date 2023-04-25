package mekatok.core.assertion;

/**
 * 字符串 断言工具
 * @author aCay
 * @since 2023.03.10
 */
public class StringAssertion extends AbstractAssertion<StringAssertion, String> {

    public StringAssertion(String actual, boolean nullable) {
        super(actual, nullable);
    }

    /**
     * 字符串不是空白
     * @return 断言工具
     */
    public StringAssertion isNotBlank(){
        if (actual.isBlank())
            throwException();
        return self();
    }

    /**
     * 字符串不是空
     * @return 断言工具
     */
    public StringAssertion isNotEmpty(){
        if (actual.isEmpty())
            throwException();
        return self();
    }

    /**
     * 判断包含
     * @param part 片段
     * @return 断言工具
     */
    public StringAssertion contains(CharSequence part){
        if (!actual.contains(part))
            throwException();
        return self();
    }

    /**
     * 是否以指定字符串结尾
     * @param end 被包含的字符
     * @return 断言工具
     */
    public StringAssertion endWith(String end){
        if (!actual.endsWith(end))
            throwException();
        return self();
    }

    /**
     * 是否以指定字符串开始
     * @param start 被包含的字符
     * @return 断言工具
     */
    public StringAssertion startWith(String start){
        if (!actual.startsWith(start))
            throwException();
        return self();
    }

    /**
     * 字符串长度等于
     * @param count 长度
     * @return 断言工具
     */
    public StringAssertion length(Integer count){
        if (actual.length() != count)
            throwException();
        return self();
    }

}
