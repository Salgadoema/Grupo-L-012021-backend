package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@EnableScheduling
public class BackendDesappAplApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendDesappAplApplication.class, args);
	}
}

