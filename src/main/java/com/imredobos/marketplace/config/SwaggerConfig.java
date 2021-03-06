package com.imredobos.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        HashSet<String> consumesAndProduces = new HashSet<String>(Arrays.asList("application/json"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metadata())
                .consumes(consumesAndProduces)
                .produces(consumesAndProduces)
                .pathMapping("/");
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Market Place API")
                .description("Market Place API Description")
                .version("1.0")
                .contact(new Contact("Imre Dobos", "https://github.com/imredobos",
                        "dobos.imre95@gmail.com"))
                .build();
    }
}
