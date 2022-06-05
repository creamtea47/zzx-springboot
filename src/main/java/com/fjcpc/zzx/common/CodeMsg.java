package com.fjcpc.zzx.common;

import lombok.Data;

/***
 * @author xiaolu LuAng
 * @create 2022-05-31 21:27
 **/
@Data
public class CodeMsg {
    private int code;
    private String message;

    /*
     * 通用模块异常5001XX
     * */
    public static CodeMsg SUCCESS = new CodeMsg(0, "SUCCESS");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg NO_DATA_ERROR = new CodeMsg(500, "数据库查到的是空数据");
    public static CodeMsg PARAMETER_ERROR = new CodeMsg(400, "缺少必要请求参数");
    public static CodeMsg AUTHENTICATION_ERROR = new CodeMsg(401, "认证失败");
    public static CodeMsg NULL_POINTER_EXCEPTION_ERROR = new CodeMsg(500, "空指针异常！请检查是否缺少参数");
    public static CodeMsg EXCEPTION_ERROR = new CodeMsg(500, "系统发生异常（CodeMsg => EXCEPTION_ERROR），请联系吓我");

    private CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }
}