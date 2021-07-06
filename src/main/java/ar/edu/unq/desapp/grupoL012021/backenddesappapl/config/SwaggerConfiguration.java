package ar.edu.unq.desapp.grupoL012021.backenddesappapl.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import springfox.documentation.service.*;

import java.util.List;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration  {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()));
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    /*

            return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("ar.edu.unq.desapp.grupoj.backenddesappapi.webservices"))
                .paths(PathSelectors.any())
                .build();
    }
    public Docket api(HttpServletRequest httpReq) {
return new Docket(DocumentationType.SWAGGER_2).select()
.apis(RequestHandlerSelectors.any())
.paths(PathSelectors.any())
.build()
.securitySchemes(Arrays.asList(apiKey()));
}
    * public class SpringFoxConfig {
		@Bean
		public Docket swaggerConfiguration() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
					.paths(PathSelectors.any())
					.build().apiInfo(apiDetails());
		}

    * */

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Re-Seña book API",
                "Proyecto Backend del Grupo L de la materia Desarrollo de Aplicaciones",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Emanuel Salgado", "https://github.com/salgadoema", "a@b.com"),
                "API License",
                "https://github.com/Salgadoema",
                Collections.emptyList());
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
        //return new ApiKey("authkey", "Authorization", "header");
    }
}

