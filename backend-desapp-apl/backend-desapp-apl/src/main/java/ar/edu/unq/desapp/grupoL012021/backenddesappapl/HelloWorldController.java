package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HelloWorldController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/hola")
    @ResponseBody
    public String saludo(){

        return "Hola Mundo!";
    }
}
