package com.prueba.restaurant;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.prueba.restaurant.security.SecurityConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("venta-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prueba.restaurant"))
                .paths(postPaths())
                .build()
                .globalOperationParameters(Collections.singletonList(new ParameterBuilder()
                        .name(SecurityConstants.HEADER_NAME)
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .description("token jwt para la venta se obtiene al loguear")
                        .required(false)
                        .build()))
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()));
    }

    @Bean
    public Docket loginApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("login-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/login"))
                .build();
    }

    private Predicate<String> postPaths() {
        return regex("/venta/.*");
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Restaurant Ventas API")
                .description("API de prueba de Ventas para un Restaurant")
                .version("1.0").build();
    }


    private ApiKey apiKey() {
        return new ApiKey("JWT", SecurityConstants.HEADER_NAME, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/venta/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));
    }
}
