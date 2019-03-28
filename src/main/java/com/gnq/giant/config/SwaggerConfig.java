package com.gnq.giant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket f1xxDocket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .select()
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
                "ruglcc",//作者
                "ruglcc",//链接显示文字
                "http://blog.csdn.net/ruglcc"//网站链接
        );
        return apiInfo;
    }
}
