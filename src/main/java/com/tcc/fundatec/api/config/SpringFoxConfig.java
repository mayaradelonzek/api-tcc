package com.tcc.fundatec.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.tcc.fundatec.api.rest"))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo());
//            .tags(new Tag("Health Controller", "Verify if API is up"),
//                    new Tag("Candidates", "Manages candidates"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Okiwi API")
            .description("Okiwi Recruiter")
            .version("1")
            .contact(new Contact("Mayara Delonzek", "https://github.com/mayaradelonzek", "mayaradelonzek2@gmail.com"))
            .build();
    }
}