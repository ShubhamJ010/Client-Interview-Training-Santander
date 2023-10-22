package com.coforge.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(userApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.coforge.springdemo.controller"))
                .build();
    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
                .title("Users API")
                .contact(new Contact("User Team", "www.coforge.com", "user@cofoge.com"))
                .description("This API manages user journey")
                .version("1.0.0")
                .build();
    }
}
