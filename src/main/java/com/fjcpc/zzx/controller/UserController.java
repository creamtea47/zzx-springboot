package com.fjcpc.zzx.controller;

import com.fjcpc.zzx.common.FwResult;
import com.fjcpc.zzx.pojo.TblUser;
import com.fjcpc.zzx.pojo.vo.Register;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public FwResult<List<HashMap>> login(@RequestBody TblUser tblUser) {
        TblUser login = tblUserService.login(tblUser);
        LOGGER.debug(String.valueOf(tblUser));
        LOGGER.debug(String.valueOf(login));
        if (login == null) {
//            return JsonResult.error(CodeMsg.AUTHENTICATION_ERROR);
            return FwResult.failedMsg("认证失败");
        } else {
            // TODO: 2022/6/7 登录接口生成token
            loginToken = TokenUtil.createToken(tblUser);
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", loginToken);
            map.put("expires_time", TokenUtil.getTokenInfo(loginToken).getExpiresAt());
            List<HashMap> mapList = new ArrayList<>();
            mapList.add(map);
            return FwResult.ok(mapList);
        }
    }

    @PostMapping("/register")
    @ApiOperation("用户注册接口")
    public FwResult<Object> register(@RequestBody Register register) {
        FwResult<TblUser> infoByUsername = getInfoByUsername(register.getUsername());
        LOGGER.debug("检查用户名重复 => {}", infoByUsername.getStatus());
        if (infoByUsername.getStatus() != 200) {
           tblUserService.register(register);
            LOGGER.debug("接收：" + String.valueOf(register));
            LOGGER.debug("结果：" + String.valueOf(register));
            return FwResult.ok();
        } else {
            return FwResult.failedMsg(422, "注册失败，账户已存在！");
        }
    }

    @GetMapping("/getInfoByUsername/{username}")
    @ApiOperation("根据用户名查询某人信息")
    public FwResult<TblUser> getInfoByUsername(@ApiParam("用户名") @PathVariable String username) {
        TblUser info = tblUserService.getInfoByUsername(username);
        LOGGER.debug("接收：" + String.valueOf(username));
        LOGGER.debug("结果：" + String.valueOf(info));
        if (info == null) {
            return FwResult.failedMsg(500, "账号不存在！");
        } else {
            return FwResult.ok(info);
        }
    }

    @GetMapping("/getInfoByUid/{uid}")
    @ApiOperation("根据uid查询某人信息")
    public FwResult<Object> getInfoByUid(@ApiParam("用户编号") @PathVariable String uid) {
        TblUser infoByUid = tblUserService.getInfoByUid(uid);
        LOGGER.debug("接收：" + String.valueOf(uid));
        LOGGER.debug("结果：" + String.valueOf(infoByUid));
        if (infoByUid == null) {
            return FwResult.failedMsg(500, "账号不存在！");
        } else {
            return FwResult.ok(infoByUid);
        }
    }

    @DeleteMapping("/deleteUserByUid/{uid}")
    @ApiOperation("根据uid删除某个用户")
    public FwResult<Object> delUserByUid(@ApiParam("用户名") @PathVariable int uid) {
        int i = tblUserService.delUserByUid(uid);
        LOGGER.debug("接收：" + String.valueOf(uid));
        LOGGER.debug("结果：" + String.valueOf(i));
        if (i == 0) {
            return FwResult.failedMsg(500, "账号不存在！");
        } else {
            return FwResult.ok();
        }
    }

    @PutMapping("/updateInfo")
    @ApiOperation("根据uid修改个人基本信息")
    public FwResult<Object> updateInfo(@RequestBody UpdateInfo updateInfo) {
        int i = tblUserService.updateInfo(updateInfo);
        LOGGER.debug("接收：" + updateInfo);
        LOGGER.debug("结果：" + i);
        if (i == 0) {
            return FwResult.failedMsg(500, "账号不存在！");
        } else {
            return FwResult.ok();
        }
    }

    @PutMapping("/resetPwd")
    @ApiOperation("根据uid修改个人密码")
    public FwResult<Object> resetPwd(@RequestBody ResetPwd resetPwd) {
        LOGGER.debug("接收：" + String.valueOf(resetPwd));
        LOGGER.debug("接收 => 旧密码：{},新密码：{}", resetPwd.getOldPassword(), resetPwd.getNewPassword());
        if (resetPwd.getNewPassword() != resetPwd.getOldPassword()) {
            int i = tblUserService.resetPwd(resetPwd);
            LOGGER.debug("结果：" + String.valueOf(i));
            return FwResult.ok();
        } else {
            return FwResult.failedMsg(500, "旧密码不能和新密码重复！");
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