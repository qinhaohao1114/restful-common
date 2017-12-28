package com.restful.org.common.exception;

/**
 * 自包装系统异常
 *
 * @author qinhaohao
 * @create 2017-12-28 16:16
 **/
public class SystemException extends RuntimeException{
    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
