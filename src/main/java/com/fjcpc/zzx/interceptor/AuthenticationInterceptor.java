package com.fjcpc.zzx.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjcpc.zzx.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*** 拦截器
 * @author xiaolu LuAng
 * @create 2022-06-06 23:09
 **/
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        System.out.println("进入拦截器");
        //实际这个名字可以指定为别的，token太没有辨识度---
        //这个header是在创建完token返回给前端时指定的头部的key，vakue就是token内容
        String token = httpServletRequest.getHeader("token");
        Map<String, Object> map = new HashMap<>();
        try {
            //这里进行token验证，捕获异常，正常的话也不需要处理，直接抛出异常，由统一异常处理类进行处理，然后返回给前端统一数据类型。
            TokenUtil.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("message", "签名不一致");
            map.put("code", 500);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("message", "令牌过期");
            map.put("code", 500);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("message", "算法不匹配");
            map.put("code", 500);
        } catch (InvalidClaimException e) {
            e.printStackTrace();
            map.put("message", "失效的payload");
            map.put("code", 500);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "此请求地址需要携带Token验证，请检查Token是否有效或存在！");
            map.put("code", 500);
        }
        //根据自己所需选择所需的异常处理
        map.put("success", false);
        //响应到前台: 将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().println(json);
        return false;
    }
}

