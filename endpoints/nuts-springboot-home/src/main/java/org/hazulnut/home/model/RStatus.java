package org.hazulnut.home.model;

/**
 * 结果状态.
 *
 * <p>返回Api执行状态
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/24 22:13: created.<br>
 */
public enum RStatus {
    /**
     * 操作成功
     */
    OK(0, "操作成功"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(999, "服务器出错啦");

    /**
     * 状态码
     */
    private int code;
    /**
     * 内容
     */
    private String message;

    RStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
