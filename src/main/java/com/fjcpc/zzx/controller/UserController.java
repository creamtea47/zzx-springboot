package com.fjcpc.zzx.controller;

import com.fjcpc.zzx.common.CodeMsg;
import com.fjcpc.zzx.common.JsonResult;
import com.fjcpc.zzx.pojo.TblUser;
import com.fjcpc.zzx.pojo.vo.ResetPwd;
import com.fjcpc.zzx.pojo.vo.UpdateInfo;
import com.fjcpc.zzx.service.TblUserService;
import com.fjcpc.zzx.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/*** 用户控制层
 * @author xiaolu LuAng
 * @create 2022-05-31 15:12
 **/
@RestController
@Api(value = "用户接口")
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private String loginToken;
    @Resource
    private TblUserService tblUserService;

    @PostMapping("/login")
    @ApiOperation("用户登录接口")
    public JsonResult<TblUser> login(@RequestBody TblUser tblUser) {
        TblUser login = tblUserService.login(tblUser);
        LOGGER.debug(String.valueOf(tblUser));
        LOGGER.debug(String.valueOf(login));
        if (login == null) {
            return JsonResult.error(CodeMsg.AUTHENTICATION_ERROR);
        } else {
            // TODO: 2022/6/7 登录接口生成token
            HashMap<String, Object> map = new HashMap<>();
            loginToken = TokenUtil.createToken(tblUser);
            map.put("token", loginToken);
            map.put("expires_time", TokenUtil.getTokenInfo(loginToken).getExpiresAt());
            return JsonResult.success(map);
        }
    }

    @PostMapping("/register")
    @ApiOperation("用户注册接口")
    public JsonResult<TblUser> register(@RequestBody TblUser tblUser) {
        JsonResult<TblUser> infoByUsername = getInfoByUsername(tblUser.getUsername());
        LOGGER.debug("检查用户名重复 => {}", infoByUsername.getCode());
        if (infoByUsername.getCode() != 200) {
            TblUser register = tblUserService.register(tblUser);
            LOGGER.debug("接收：" + String.valueOf(tblUser));
            LOGGER.debug("结果：" + String.valueOf(register));
            return JsonResult.success();
        } else {
            return JsonResult.error(CodeMsg.ACCOUNT_ALREADY_EXISTS);
        }
    }

    @GetMapping("/getInfoByUsername/{username}")
    @ApiOperation("根据用户名查询某人信息")
    public JsonResult<TblUser> getInfoByUsername(@ApiParam("用户名") @PathVariable String username) {
        TblUser info = tblUserService.getInfoByUsername(username);
        LOGGER.debug("接收：" + String.valueOf(username));
        LOGGER.debug("结果：" + String.valueOf(info));
        if (info == null) {
            return JsonResult.error(CodeMsg.ACCOUNT_DOES_NOT_EXIST);
        } else {
            return JsonResult.success(info);
        }
    }

    @GetMapping("/getInfoByUid/{uid}")
    @ApiOperation("根据uid查询某人信息")
    public JsonResult<TblUser> getInfoByUid(@ApiParam("用户编号") @PathVariable String uid) {
        TblUser infoByUid = tblUserService.getInfoByUid(uid);
        LOGGER.debug("接收：" + String.valueOf(uid));
        LOGGER.debug("结果：" + String.valueOf(infoByUid));
        if (infoByUid == null) {
            return JsonResult.error(CodeMsg.ACCOUNT_DOES_NOT_EXIST);
        } else {
            return JsonResult.success(infoByUid);
        }
    }

    @DeleteMapping("/deleteUserByUid/{uid}")
    @ApiOperation("根据uid删除某个用户")
    public JsonResult<TblUser> delUserByUid(@ApiParam("用户名") @PathVariable int uid) {
        int i = tblUserService.delUserByUid(uid);
        LOGGER.debug("接收：" + String.valueOf(uid));
        LOGGER.debug("结果：" + String.valueOf(i));
        if (i == 0) {
            return JsonResult.error(CodeMsg.ACCOUNT_DOES_NOT_EXIST);
        } else {
            return JsonResult.success(null);
        }
    }

    @PutMapping("/updateInfo")
    @ApiOperation("根据uid修改个人基本信息")
    public JsonResult<TblUser> updateInfo(@RequestBody UpdateInfo updateInfo) {
        int i = tblUserService.updateInfo(updateInfo);
        LOGGER.debug("接收：" + updateInfo);
        LOGGER.debug("结果：" + i);
        if (i == 0) {
            return JsonResult.error(CodeMsg.ACCOUNT_DOES_NOT_EXIST);
        } else {
            return JsonResult.success(null);
        }
    }

    @PutMapping("/resetPwd")
    @ApiOperation("根据uid修改个人密码")
    public JsonResult<TblUser> resetPwd(@RequestBody ResetPwd resetPwd) {
        LOGGER.debug("接收：" + String.valueOf(resetPwd));
        LOGGER.debug("接收 => 旧密码：{},新密码：{}", resetPwd.getOldPassword(), resetPwd.getNewPassword());
        if (resetPwd.getNewPassword() != resetPwd.getOldPassword()) {
            int i = tblUserService.resetPwd(resetPwd);
            LOGGER.debug("结果：" + String.valueOf(i));
            return JsonResult.success();
        } else {
            return JsonResult.error(CodeMsg.OLD_AND_NEW_PASSWORDS_DUPLICATE);
        }
    }

//    @GetMapping("/balanceList")
//    @ApiOperation("金额变动记录")
//    public JsonResult<TblUser> balanceList() {
//        return null;
//    }

//    @PostMapping("/balanceRecharge")
//    @ApiOperation("金额充值")
//    public JsonResult<TblUser> balanceRecharge() {
//        return null;
//    }
}