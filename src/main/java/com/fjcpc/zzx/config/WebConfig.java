package com.fjcpc.zzx.config;

import com.fjcpc.zzx.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/*** 注册拦截器
 * @author xiaolu LuAng
 * @create 2022-06-07 20:56
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePathLists = new ArrayList<>();
        //注册、登录允许访问，不进行拦截
        excludePathLists.add("/user/login");
        excludePathLists.add("/user/register");
        excludePathLists.add("/user/info");
        excludePathLists.add("/swagger-resources/**");
        excludePathLists.add("/swagger-ui/**");
        excludePathLists.add("/v3/**");
        excludePathLists.add("/error");
        excludePathLists.add("/doc.html");
        excludePathLists.add("/webjars/**");

        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathLists);
    }
}