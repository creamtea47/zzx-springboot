package com.fjcpc.zzx.common;

import java.time.LocalDateTime;

/*** 封装统一返回的json数据结构
 * @author xiaolu LuAng
 * @create 2022-05-31 10:29
 **/
public class JsonResult<T> {

    private int code;
    private String message;
    private T data;
    private LocalDateTime time;

    /**
     * 成功时调用
     *
     * @param data
     * @param <T>
     * @return
     */

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(data);
    }

    public static <T> JsonResult<T> success() {
        return new JsonResult<T>();
    }


    /**
     * 失败时调用
     *
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> JsonResult error(CodeMsg codeMsg) {
        return new JsonResult<T>(codeMsg);
    }

    /**
     * 构造方法私有化，不允许外部new JsonResult
     *
     * @param data
     */
    private JsonResult(T data) {
        this.code = 200;
        this.message = "操作成功！";
        this.data = data;
        this.time = LocalDateTime.now();
    }

    public JsonResult() {
        this.code = 200;
        this.message = "操作成功！";
        this.time = LocalDateTime.now();
    }

    /**
     * 构造方法私有化，不允许外部new JsonResult
     *
     * @param codeMsg
     */
    private JsonResult(CodeMsg codeMsg) {
        if (null == codeMsg) {
            return;
        }
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
        this.time = LocalDateTime.now();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}