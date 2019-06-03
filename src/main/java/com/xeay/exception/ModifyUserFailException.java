package com.xeay.exception;

/**
 * 异常-修改失败
 */
public class ModifyUserFailException extends RuntimeException{
    public ModifyUserFailException(String message) {
        super(message);
    }

    public ModifyUserFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
