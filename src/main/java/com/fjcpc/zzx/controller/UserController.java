package com.fjcpc.zzx.controller;

import com.fjcpc.zzx.common.CodeMsg;
import com.fjcpc.zzx.common.JsonResult;
import com.fjcpc.zzx.pojo.TblUser;
import com.fjcpc.zzx.pojo.vo.ResetPwd;
import com.fjcpc.zzx.service.TblUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*** 用户控制层
 * @author xiaolu LuAng
 * @create 2022-05-31 15:12
 **/
@RestController
@Api(value = "用户接口")
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
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
            return JsonResult.success();
        }
    }

    @PostMapping("/register")
    @ApiOperation("用户注册接口")
    public JsonResult<TblUser> register(@RequestBody TblUser tblUser) {
        try {
            TblUser register = tblUserService.register(tblUser);
            LOGGER.debug("接收：" + String.valueOf(tblUser));
            LOGGER.debug("结果：" + String.valueOf(register));
            return JsonResult.success();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getInfoByUsername/{username}")
    @ApiOperation("根据用户名查询某人信息")
    public JsonResult<TblUser> getInfoByUsername(@ApiParam("用户名") @PathVariable String username) {
        TblUser info = tblUserService.getInfoByUsername(username);
        LOGGER.debug("接收：" + String.valueOf(username));
        LOGGER.debug("结果：" + String.valueOf(info));
        if (info == null) {
            return JsonResult.error(CodeMsg.NO_DATA_ERROR);
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
            return JsonResult.error(CodeMsg.NO_DATA_ERROR);
        } else {
            return JsonResult.success(infoByUid);
        }
    }

    @DeleteMapping("/deleteUserByUid/{uid}")
    @ApiOperation("根据uid删除某个用户")
    public JsonResult<TblUser> delUserByUid(@ApiParam("用户名") @PathVariable int uid) {
        TblUser tblUser = tblUserService.delUserByUid(uid);
        LOGGER.debug("接收：" + String.valueOf(uid));
        LOGGER.debug("结果：" + String.valueOf(tblUser));
//        if (tblUser == null) {
//            return JsonResult.error(CodeMsg.NO_DATA_ERROR);
//        } else {
//            return JsonResult.success(tblUser);
//        }
        // FIXME: 2022/6/1 无论如何都异常，但是能删除成功
        return JsonResult.success(null);
    }

    @PutMapping("/updateInfo")
    @ApiOperation("根据uid修改个人基本信息")
    public JsonResult<TblUser> updateInfo(@RequestBody TblUser tblUser) {
        int tblUser1 = tblUserService.updateInfo(tblUser);
        LOGGER.debug("接收：" + String.valueOf(tblUser));
        LOGGER.debug("结果：" + String.valueOf(tblUser1));
        return JsonResult.success();
    }

    @PutMapping("/resetPwd")
    @ApiOperation("根据uid修改个人密码")
    public JsonResult<TblUser> resetPwd(@PathVariable("id") int id, @RequestBody ResetPwd resetPwd) {
//        int i = tblUserService.resetPwd(resetPwd);
//        LOGGER.debug("接收：" + String.valueOf(tblUser));
//        LOGGER.debug("结果：" + String.valueOf(tblUser1));
        return null;
    }

    @GetMapping("/balanceList")
    @ApiOperation("金额变动记录")
    public JsonResult<TblUser> balanceList() {
        return null;
    }

    @PostMapping("/balanceRecharge")
    @ApiOperation("金额充值")
    public JsonResult<TblUser> balanceRecharge() {
        return null;
    }
}