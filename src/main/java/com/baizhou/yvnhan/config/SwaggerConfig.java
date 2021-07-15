package com.baizhou.yvnhan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author HaiPeng Wang
 * @date 2021/7/14 16:28
 * @Description:
 */
@EnableSwagger2   //开启Swagger 注解
@Configuration
public class SwaggerConfig {
    //配置Swagger 的Docket 信息
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("wang");
        /*
        true 表示再
        false 表示不在
         */
        boolean open = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //配置文档信息
                .enable(open)   //wang是我的开发环境，如果是这个环境的话就打开swagger，而是不是这个环境是再spring.profiles.active 配置的
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.baizhou.yvnhan.controller"))
                    .paths(PathSelectors.ant("/**")) //允许访问所有映射下的接口
                .build();


    }

    private ApiInfo apiInfo() {
        /**
         * ApiInfo 对象并没有构造方法所以必须用构造器
         */
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("王海澎", "http://没有.com", "baizhouWHP@163.com");
        return new ApiInfo(
                "云翰",   //Swagger APi文档标题
                "云顶书院云翰项目API文档",//Api 文档描述
                "1.1", //文档版本
                "云泽项目组",
                DEFAULT_CONTACT,
                "Apache 2.0",//开源版本号
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
