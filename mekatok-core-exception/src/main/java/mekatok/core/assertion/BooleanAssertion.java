package mekatok.core.assertion;

/**
 * 布尔值 断言工具
 * @author aCay
 * @since 2023.03.10
 */
public class BooleanAssertion extends AbstractAssertion<BooleanAssertion,Boolean> {

    public BooleanAssertion(Boolean actual, boolean nullable) {
        super(actual, nullable);
    }

    /**
     * 是真
     * @return 断言工具
     */
    public BooleanAssertion isTrue(){
        return equalsByDefault(Boolean.TRUE);
    }

    /**
     * 是假
     * @return 断言工具
     */
    public BooleanAssertion isFalse(){
        return equalsByDefault(Boolean.FALSE);
    }
}
