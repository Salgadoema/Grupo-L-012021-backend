package ar.edu.unq.desapp.grupoL012021.backenddesappapl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BackendDesappAplApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendDesappAplApplication.class, args);
	}

}
