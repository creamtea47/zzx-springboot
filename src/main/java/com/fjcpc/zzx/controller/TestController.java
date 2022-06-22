package com.fjcpc.zzx.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fjcpc.zzx.common.FwResult;
import com.fjcpc.zzx.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    public FwResult<DecodedJWT> verifyToken(@RequestHeader String token) {
        LOGGER.debug(token);
        DecodedJWT verify = TokenUtil.verify(token);
        return FwResult.ok(verify);
    }

    @ApiOperation("测试解析Token")
    @PostMapping("/getTokenInfo")
    public FwResult<DecodedJWT> getTokenInfo(@RequestHeader String token) {
        LOGGER.debug(token);
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        return FwResult.ok(tokenInfo);
    }

    @ApiOperation("结束Spring Boot进程")
    @GetMapping("/executeKill")
    public void executeKill(){
        System.exit(0);
    }
}