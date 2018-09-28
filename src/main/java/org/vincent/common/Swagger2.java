package org.vincent.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.charset.StandardCharsets;

/**
 * Created by PengRong on 2018/9/28.
 * Swagger2 配置 类
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * 开关
     */
    @Value("${swagger.open}")
    private boolean swaggerOpen;

    @Value("${swagger.title}")
    private String title;// 当前文档的标题
    @Value("${swagger.description}")
    private String description;// 当前文档的详细描述
    @Value("${swagger.version}")
    private String version;// 当前文档的版本
    @Value("${server.port}")
    private  String serverPort;

    @Bean
    public Docket createRestApi() {
        if (swaggerOpen) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("org.vincent.web.controller"))
                    .paths(PathSelectors.any())
                    .build();
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfoOnline())
                    .select()
                    .paths(PathSelectors.none())
                    .build();
        }

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(new String(title.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8))
                .description(new String(description.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8))
                .termsOfServiceUrl("localhost:"+serverPort+"/spring-boot-in-action/")
                .version(new String(version.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8))
                .build();
    }

    private ApiInfo apiInfoOnline() {
        return new ApiInfoBuilder()
                .title("")
                .description("")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("")
                .build();
    }

    /*public void setSwaggerOpen(boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }*/
}
