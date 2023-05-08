package mekatok.core.exception.provider;

import mekatok.core.exception.ExceptionMark;

/**
 * 系统读取磁盘文件失败
 * @author GuoCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "B0321", message = "The system failed to read the disk file")
public class FileAccessException extends ResourceAccessException{

    public FileAccessException() {
    }

    public FileAccessException(String message) {
        super(message);
    }

    public FileAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileAccessException(Throwable cause) {
        super(cause);
    }

    public FileAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
