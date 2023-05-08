package mekatok.core.exception.consumer.file;

import mekatok.core.exception.ExceptionMark;

/**
 * 文件过大
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "A0702", message = "File too big")
public class FileTooBigException extends FileException{

    public FileTooBigException() {
    }

    public FileTooBigException(String message) {
        super(message);
    }

    public FileTooBigException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTooBigException(Throwable cause) {
        super(cause);
    }

    public FileTooBigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
