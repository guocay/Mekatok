package mekatok.core.exception.consumer.file;

import mekatok.core.exception.ExceptionMark;

/**
 * 压缩文件过大
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0705", message = "Compressed file too big")
public class CompressedFileException extends FileException{

    public CompressedFileException() {
    }

    public CompressedFileException(String message) {
        super(message);
    }

    public CompressedFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompressedFileException(Throwable cause) {
        super(cause);
    }

    public CompressedFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
