package com.fjcpc.zzx.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fjcpc.zzx.common.JsonResult;
import com.fjcpc.zzx.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*** 测试控制器
 * @author xiaolu LuAng
 * @create 2022-06-07 07:39
 **/
@RestController
@RequestMapping("/test")
@Api("测试控制层")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @ApiOperation("测试验证Token")
    @PostMapping("/verifyToken")
    public JsonResult verifyToken(@RequestHeader String token) {
        LOGGER.debug(token);
        DecodedJWT verify = TokenUtil.verify(token);
        return JsonResult.success(verify);
    }

    @ApiOperation("测试解析Token")
    @PostMapping("/getTokenInfo")
    public JsonResult getTokenInfo(@RequestHeader String token) {
        LOGGER.debug(token);
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        return JsonResult.success(tokenInfo);
    }
}