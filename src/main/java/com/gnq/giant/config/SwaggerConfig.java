package com.gnq.giant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.gnq.giant")
public class SwaggerConfig {

    @Bean
    public Docket f1xxDocket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gnq.giant"))
                .paths(PathSelectors.regex("/api/f[1-9][0-9][0-9]"))
                .build()
                .apiInfo(f1xxApiInfo());

        return docket;
    }

    private ApiInfo f1xxApiInfo() {
        ApiInfo apiInfo = new ApiInfo("大标题",//大标题
                "用户管理相关接口",//小标题
                "v1.0",//版本
                "描述",
                "NightGuo",//作者
                "NightGuo",//链接显示文字
                "http://blog.csdn.net/ruglcc"//网站链接
        );
        return apiInfo;
    }
}
