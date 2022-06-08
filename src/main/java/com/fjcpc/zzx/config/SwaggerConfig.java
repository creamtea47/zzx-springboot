package com.fjcpc.zzx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*** Swagger配置类
 * @author xiaolu LuAng
 * @create 2022-05-31 10:56
 **/
@Configuration
//@EnableSwagger2
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        // 指定构建api文档的详细信息的方法：apiInfo()
        return new Docket(DocumentationType.OAS_30)
                // TODO: 2022/5/30 指定构建api文档的详细信息的方法
                .apiInfo(apiInfo())
                // 通过select()方法来配置扫描哪些接口。
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中所有的接口
                .apis(RequestHandlerSelectors.basePackage("com.fjcpc.zzx.controller"))
                // 根据请求路径定义当前Docket需要包含控制器的哪些方法。
                // any():扫描所有请求路径
                // none():不扫描
                // ant(final String antPattern):匹配Ant样式的路径模式
                // regex(final String pathRegex):匹配正则指定的正则表达式路径}|
                .paths(PathSelectors.any())

//                .securityContexts(securityContexts())
//                .securitySchemes(securitySchemes())
                // 构建
                .build();
    }

    /*
     * 构建api文档的详细信息
     * @return
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("Spring Boot 2.7.0 接口总览")
                // 设置接口描述
                .description("Scan path:com.fjcpc.zzx.controller")
                // 设置联系方式
//                .contact("FJCPC")
                .contact(new Contact("FJCPC", "fjcpc.edu.com", "fjcpc@edu.com"))
                .version("1.0.3")
                .build();
    }

}