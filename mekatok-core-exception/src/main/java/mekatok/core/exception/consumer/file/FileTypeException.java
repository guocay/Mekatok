package mekatok.core.exception.consumer.file;

import mekatok.core.exception.ExceptionMark;

/**
 * 文件类型不匹配
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0701", message = "File type mismatch")
public class FileTypeException extends FileException{

    public FileTypeException() {
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
