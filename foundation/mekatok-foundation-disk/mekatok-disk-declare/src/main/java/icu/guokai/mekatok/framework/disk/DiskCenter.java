package icu.guokai.mekatok.framework.disk;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import icu.guokai.mekatok.framework.core.asserts.Assertions;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.disk.model.table.DiskDirectory;
import icu.guokai.mekatok.framework.disk.model.table.DiskFile;
import icu.guokai.mekatok.framework.disk.model.tran.DiskFileTran;
import icu.guokai.mekatok.framework.disk.model.view.DiskElement;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * 磁盘管理中心
 * @author GuoKai
 * @date 2021/11/4
 */
public abstract class DiskCenter {

    /**
     * 上传文件
     * @param file 文件
     * @return file对象
     */
    public static DiskFile uploadFile(File file){
        return uploadFile(file, null);
    }

    /**
     * 上传文件至指定目录
     * @param file 文件
     * @param path 上级目录
     * @return file对象
     */
    public static DiskFile uploadFile(File file, String path){
        var fileParent = Optional.ofNullable(path).orElse(Global.DEFAULT_FILE_PATH);
        var fileName = DateUtil.current() + "";
        // todo 保存文件至磁盘
        FileUtil.copy(file,new File(Global.RESOURCE_FILE_PATH + fileName), true);
        // todo 保存 DiskFile 对象
        return addFile(new DiskFile().setOriginalName(file.getName()).setFileParent(fileParent).setFileSize(file.length() + "")
                .setFileType(FileUtil.getType(file)).setFileName(fileName));
    }

    /**
     * 上传文件至指定目录
     * @param file 文件
     * @param path 上级目录
     * @return file对象
     */
    public static DiskFile uploadFile(MultipartFile file, String path){
        var fileParent = Optional.ofNullable(path).orElse(Global.DEFAULT_FILE_PATH);
        var fileName = DateUtil.current() + "";
        try {
            file.transferTo(new File(Global.RESOURCE_FILE_PATH + fileName));
            return addFile(new DiskFile().setOriginalName(file.getOriginalFilename()).setFileParent(fileParent).setFileSize(file.getSize() + "")
                    .setFileType(file.getContentType()).setFileName(fileName));
        } catch (IOException e) {
            throw new MekatokException(e);
        }
    }

    /**
     * 新增目录
     * @param dir 目录
     * @return 目录
     */
    public static DiskDirectory addDirectory(DiskDirectory dir){
        return dir.save();
    }

    /**
     * 新增文件
     * @param file 文件
     * @return 文件
     */
    public static DiskFile addFile(DiskFile file){
        return file.save();
    }

    /**
     * 删除目录至垃圾箱
     * @param dirId 目录主键
     * @return 操作成功
     */
    public static Boolean directoryToTrash(String dirId){
        new DiskDirectory().setId(dirId).setTrash(true).update();
        return true;
    }

    /**
     * 删除文件至垃圾箱
     * @param fileId 目录主键
     * @return 操作成功
     */
    public static Boolean fileToTrash(String fileId){
        new DiskFile().setId(fileId).setTrash(true).update();
        return true;
    }

    /**
     * 彻底删除目录
     * @param dirId 目录主键
     * @return 操作成功
     */
    public static Boolean removeDirectory(String dirId){
        return new DiskDirectory().setId(dirId).delete();
    }

    /**
     * 彻底删除文件
     * @param fileId 目录主键
     * @return 操作成功
     */
    public static Boolean removeFile(String fileId){
        return new DiskFile().setId(fileId).delete();
    }

    /**
     * 获取目录下设目录与文件
     * @param dirCode 目录编码
     * @return 磁盘元素
     */
    public static List<DiskElement> son(String dirCode){
        return new DiskElement().setElementKey(dirCode).selectList();
    }

    /**
     * 获取文件对象
     * @param fileId 目录主键
     * @return 文件对象
     */
    public static DiskFileTran download(String fileId){
        var diskFile = file(fileId);
        Assertions.assertThat(diskFile).hasId();
        return new DiskFileTran().setOriginalName(diskFile.getOriginalName()).setFileName(diskFile.getFileName())
                .setFile(FileUtil.readBytes(Global.RESOURCE_FILE_PATH + diskFile.getFileName()));
    }

    /**
     * 获取文件数据库对象
     * @param fileId 目录主键
     * @return 文件对象
     */
    public static DiskFile file(String fileId){
        return new DiskFile().setId(fileId).detail();
    }

}
