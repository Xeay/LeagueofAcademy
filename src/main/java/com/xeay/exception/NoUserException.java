package com.xeay.exception;

/**
 * 异常-用户不存在
 */
public class NoUserException extends RuntimeException {

    public NoUserException(String message) {
        super(message);
    }

    public NoUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
