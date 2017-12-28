package com.restful.org.common.exception;

/**
 * 连接异常
 *
 * @author qinhaohao
 * @create 2017-12-28 16:17
 **/
public class ConnctException extends SystemException{
    public ConnctException(String message) {
        super(message);
    }

    public ConnctException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnctException(Throwable cause) {
        super(cause);
    }
}
