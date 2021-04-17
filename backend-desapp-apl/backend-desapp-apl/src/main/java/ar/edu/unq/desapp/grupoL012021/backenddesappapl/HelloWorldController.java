package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class HelloWorldController {

    @GetMapping("/hola")
    public String saludo(){
        return "Hola mundo!";
    }
}
