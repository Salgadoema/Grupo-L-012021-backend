package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@EnableScheduling
public class BackendDesappAplApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendDesappAplApplication.class, args);
	}

	@Configuration
	@EnableSwagger2

	public class SpringFoxConfig {
		@Bean
		public Docket swaggerConfiguration() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
					.paths(PathSelectors.any())
					.build().apiInfo(apiDetails());
		}

		private ApiInfo apiDetails() {
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
	}
}

