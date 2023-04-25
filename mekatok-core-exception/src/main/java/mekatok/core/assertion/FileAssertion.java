package mekatok.core.assertion;

import java.io.File;

/**
 * 文件 断言工具类
 * @author aCay
 * @since 2023.03.10
 */
public class FileAssertion extends AbstractAssertion<FileAssertion, File>{

    public FileAssertion(File actual, boolean nullable) {
        super(actual, nullable);
    }

    /**
     * 是目录
     * @return 断言工具
     */
    public FileAssertion isDirectory(){
        if (!actual.isDirectory())
            throwException();
        return self();
    }

    /**
     * 是文件
     * @return 断言工具
     */
    public FileAssertion isFile(){
        if (!actual.isFile())
            throwException();
        return self();
    }

    /**
     * 非空
     * @return 断言工具
     */
    public FileAssertion isNotEmpty(){
        if (actual.length() > 0)
            throwException();
        return self();
    }

    /**
     * 存在
     * @return 断言工具
     */
    public FileAssertion isExist(){
        if (!actual.exists())
            throwException();
        return self();
    }
}
