package org.hazulnut.home.model;

/**
 * 统一返回结果.
 *
 * <p>统一返回结构体
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/24 22:17: created.<br>
 */
public class RResponse {
    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /*
     * 异常详情
     */
    private Exception exception;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * 无参构造函数
     */
    private RResponse() {
    }

    /**
     * 全参构造函数
     *
     * @param code      状态码
     * @param message   返回内容
     * @param data      返回数据
     * @param exception 异常详情
     */
    private RResponse(int code, String message, Object data, Exception exception) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.exception = exception;
    }

    /**
     * 构造一个自定义的API返回
     *
     * @param code      状态码
     * @param message   返回内容
     * @param data      返回数据
     * @param exception 异常详情
     * @return RResponse
     */
    public static RResponse of(int code, String message, Object data, Exception exception) {
        return new RResponse(code, message, data, exception);
    }

    /**
     * 构造一个成功且带数据的API返回
     *
     * @param data 返回数据
     * @return RResponse
     */
    public static RResponse ofSuccess(Object data) {
        return ofStatus(RStatus.OK, data);
    }

    /**
     * 构造一个成功且自定义消息的API返回
     *
     * @param message 返回内容
     * @return RResponse
     */
    public static RResponse ofMessage(String message) {
        return of(RStatus.OK.getCode(), message, null, null);
    }

    /**
     * 构造一个有状态的API返回
     *
     * @param status 状态 {@link RStatus}
     * @return RResponse
     */
    public static RResponse ofStatus(RStatus status) {
        return ofStatus(status, null);
    }

    /**
     * 构造一个有状态且带数据的API返回
     *
     * @param status 状态 {@link RStatus}
     * @param data   返回数据
     * @return RResponse
     */
    public static RResponse ofStatus(RStatus status, Object data) {
        return of(status.getCode(), status.getMessage(), data, null);
    }

    /**
     * 构造一个异常且带数据的API返回
     *
     * @param t    异常
     * @param data 返回数据
     * @param <T>  {@link Exception} 的子类
     * @return RResponse
     */
    public static <T extends Exception> RResponse ofException(T t, Object data) {
        return of(1, t.getMessage(), data, t);
    }

    /**
     * 构造一个异常且带数据的API返回
     *
     * @param t   异常
     * @param <T> {@link Exception} 的子类
     * @return RResponse
     */
    public static <T extends Exception> RResponse ofException(T t) {
        return ofException(t, null);
    }
}
