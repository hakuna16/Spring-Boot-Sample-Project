package com.rituj.elasticsearch.conf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This file is used to configure the swagger using swagger2 configuration
 * provided by the SpringFox. We are using {@link EnableSwagger2} class to
 * enable the swagger configuration for the project.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguraiton {

    /**
     * This property will be used to set the Application name in the swagger.
     */
    @Value("${swagger.application.title}")
    private String title;

    /**
     * This property is used to set the project description for the application.
     */
    @Value("${swagger.application.description}")
    private String description;

    /**
     * This is used to set the value of the version which we want to see in the
     * swagger.
     */
    @Value("${swagger.application.version}")
    private String version;

    /**
     * This property is used to set the application contact name.
     */
    @Value("${swagger.application.contact.name}")
    private String contactName;

    /**
     * This property is used to set the contact url.
     */
    @Value("${swagger.application.contact.url}")
    private String contactUrl;

    /**
     * This method is used to set the contact person email.
     */
    @Value("${swagger.application.contact.email}")
    private String contactEmail;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().apiInfo(apiInfo()).securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    /**
     * This method is used to set the application meta data like email , contact
     * etc. <br/>
     * 
     * @return an instance of {@link ApiInfo} which will help {@link Docket} to
     *         render the swagger.
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description)
                .contact(new Contact(contactName, contactUrl, contactEmail)).build();
    }

    /**
     * This method is used to build the security context for the application. <br/>
     * 
     * @return an instance of
     *         {@link SecurityContext#SecurityContext(List, com.google.common.base.Predicate)}
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
    }

    /**
     * This method adds the default authentication for the swagger.
     * @return {@link List} of {@link SecurityReference}.
     */
    private List<SecurityReference> defaultAuth() {
        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[] { authorizationScope };
        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
    }

    /**
     * This method is used to pass the authentication key as the header in the swagger.
     * @return
     */
    private ApiKey apiKey() {
        return new ApiKey("Bearer", "Authorization", "header");
    }
}
