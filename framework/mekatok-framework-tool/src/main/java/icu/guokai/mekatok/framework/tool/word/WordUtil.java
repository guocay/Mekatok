package icu.guokai.mekatok.framework.tool.word;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

/**
 * word文件操作工具类
 * @author GuoKai
 * @date 2021/11/15
 */
@SuppressWarnings("all")
public abstract class WordUtil extends cn.hutool.poi.word.WordUtil {

    /**
     * word文件转pdf文件
     * @param wordPath word文件路径
     * @param pdfPath pdf文件路径
     * @return 是否转换成功
     */
    public static Boolean convertDocxToPDF(String wordPath, String pdfPath){
        try {
            var doc = new Document(wordPath);
            doc.save(pdfPath, SaveFormat.PDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
