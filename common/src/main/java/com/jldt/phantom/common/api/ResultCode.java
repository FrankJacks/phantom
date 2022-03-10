package com.jldt.phantom.common.api;

/**
 * 枚举了一些常用API操作码
 *
 * @author 史俊鹏
 * @date 2021/12/19
 */
public enum ResultCode implements IErrorCode {
    /**
     * Success result code.
     */
    SUCCESS(200, "操作成功"),
    /**
     * Failed result code.
     */
    FAILED(500, "操作失败"),
    /**
     * Validate failed result code.
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * Unauthorized result code.
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * Forbidden result code.
     */
    FORBIDDEN(403, "没有相关权限");
    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
