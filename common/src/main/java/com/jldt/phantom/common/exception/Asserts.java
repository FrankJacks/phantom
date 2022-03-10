package com.jldt.phantom.common.exception;

import com.jldt.phantom.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author 史俊鹏
 * @date 2020/2/27
 */
public class Asserts {

    /**
     * Fail.
     *
     * @param message the message
     */
    public static void failException(boolean condition, String message) {
        if (condition) {
            throw new ApiException(message);
        }
    }

    /**
     * Fail.
     *
     * @param message the message
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * Fail.
     *
     * @param errorCode the error code
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
