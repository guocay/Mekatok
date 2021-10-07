package icu.guokai.mekatok.framework.core.asserts;

import icu.guokai.mekatok.framework.core.asserts.exception.AssertionsException;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class AssertTest implements WithAssertions{

    public void test(String[] args) {
        var a = assertThat(args)
                .as(() -> new AssertionsException("000")).isNull().is("8","123")
                .as(() -> new MekatokException("111")).isAllNull().isNotNull()
                .as(() -> new AssertionsException("222")).isEmpty().contains("5")
                .as(() -> new MekatokException("333")).isNotEmpty();

        var aa = assertThat(true).isFalse().isTrue();

        var aaa = assertThat("test").count(4).startWith("te");



    }

}
