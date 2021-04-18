package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;
/*//import io.javalin.Javalin;


public class Reviewable {
    public static void main(String[] args){
  //      Javalin app=Javalin.create().start(7000);
    //    app.get("/", ctx ->ctx.result("Hello World"));
        System.out.println("hola mundo");

    }
}*/
import java.util.Arrays;

        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Reviewable  {

    public static void main(String[] args) {
        SpringApplication.run(Reviewable.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}