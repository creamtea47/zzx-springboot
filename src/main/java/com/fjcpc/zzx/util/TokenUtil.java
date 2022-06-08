package com.fjcpc.zzx.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fjcpc.zzx.pojo.TblUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/*** 用于创建、获取、验证Token
 * @author xiaolu LuAng
 * @create 2022-06-06 22:49
 **/
@Slf4j
@Component
public class TokenUtil {

    // TODO: 2022/6/6 密钥
    public static final String SECRET = "ZZX??YYDS!!666";

    // TODO: 2022/6/6 过期时间（秒）
    public static final int EXPIRE = 86400;

    // TODO: 2022/6/7 临时存储Token
    public static String token;

    /*
     * 生成 Token
     * */
    public static String createToken(TblUser user) {
        Calendar nowTime = Calendar.getInstance();
        // 过期时间
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();
        token = JWT.create()
                // 设置第二部分，记住：不要在这里获取密码，这些信息可以被浏览器获取！
                .withClaim("uid", String.valueOf(user.getUid()))
                .withClaim("username", user.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(expireDate)// 过期时间
                // 设置第一部分
                .sign(Algorithm.HMAC256(SECRET));// 签名
        return token;
    }

    /*
     * 验证Token
     * */
    public static DecodedJWT verify(String token) {
        // TODO: 2022/6/6 如果有任何验证异常，此处都会抛出异常 我们需要在拦截器调用这个方法，捕获异常，然后返回错误信息给前端
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return decodedJWT;
    }

    /*
     * 获取token中的 payload，也就是第二部分的信息
     * */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
//        TokenUtil.getTokenInfo(token).getClaim("username").asString();
        return decodedJWT;
    }


}