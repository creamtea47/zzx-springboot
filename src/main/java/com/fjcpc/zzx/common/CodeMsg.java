package com.fjcpc.zzx.common;

import lombok.Data;

/***
 * @author xiaolu LuAng
 * @create 2022-05-31 21:27
 **/
@Data
public class CodeMsg {
    private int code;
    private boolean success;
    private String message;

    /*
     * 通用模块异常5001XX
     * */
//    public static CodeMsg SUCCESS = new CodeMsg(0, true,"SUCCESS");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, false, "服务端异常");
    public static CodeMsg NO_DATA_ERROR = new CodeMsg(500, false, "数据库查到的是空数据");
    public static CodeMsg PARAMETER_ERROR = new CodeMsg(400, false, "缺少必要请求参数");
    public static CodeMsg AUTHENTICATION_ERROR = new CodeMsg(401, false, "认证失败");
    public static CodeMsg NULL_POINTER_EXCEPTION_ERROR = new CodeMsg(500, false, "空指针异常！请检查是否缺少参数");
    public static CodeMsg EXCEPTION_ERROR = new CodeMsg(500, false, "系统发生异常（CodeMsg => EXCEPTION_ERROR），请联系吓我");
    public static CodeMsg ACCOUNT_ALREADY_EXISTS = new CodeMsg(422, false, "注册失败！");
    public static CodeMsg ACCOUNT_DOES_NOT_EXIST = new CodeMsg(500, false, "账号不存在！");
    public static CodeMsg OLD_AND_NEW_PASSWORDS_DUPLICATE = new CodeMsg(500, false, "旧密码不能和新密码重复！");

    private CodeMsg(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}