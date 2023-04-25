package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.io.FileUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;

import java.io.File;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class FileAssert extends Assert<FileAssert, File> {
    /**
     * 构造器
     * @param actual 待断言对象
     */
    public FileAssert(File actual) {
        super(actual);
    }

    @Override
    public FileAssert is(File obj){
        return exception(FileUtil.equals(actual, obj));
    }

    /**
     * 是目录
     * @return 断言工具
     */
    public FileAssert isDirectory(){
        return exception(FileUtil.isDirectory(actual));
    }

    /**
     * 是文件
     * @return 断言工具
     */
    public FileAssert isFile(){
        return exception(FileUtil.isFile(actual));
    }

    /**
     * 是链接
     * @return 断言工具
     */
    public FileAssert isSymlink(){
        return exception(FileUtil.isSymlink(actual));
    }

    /**
     * 是空
     * @return 断言工具
     */
    public FileAssert isEmpty(){
        return exception(FileUtil.isEmpty(actual));
    }

    /**
     * 非空
     * @return 断言工具
     */
    public FileAssert isNotEmpty(){
        return exception(FileUtil.isNotEmpty(actual));
    }

    /**
     * 存在
     * @return 断言工具
     */
    public FileAssert isExist(){
        return exception(FileUtil.exist(actual));
    }

    /**
     * 不存在
     * @return 断言工具
     */
    public FileAssert isNotExist(){
        return exception(!FileUtil.exist(actual));
    }

    /**
     * 文件大小
     * @param count 大小
     * @return 断言工具
     */
    public FileAssert size(Long count){
        return exception(FileUtil.size(actual) == count);
    }

    /**
     * 主文件名
     * @param prefix 主文件名
     * @return 断言工具
     */
    public FileAssert prefix(String prefix){
        return exception(FileUtil.getPrefix(actual).equals(prefix));
    }

    /**
     * 文件扩展名
     * @param suffix 文件扩展名
     * @return 断言工具
     */
    public FileAssert suffix(String suffix){
        return exception(FileUtil.getSuffix(actual).equals(suffix));
    }

}
