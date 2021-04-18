package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    //public Map res = Collections.singletonMap("res", "Hola Mundo");

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/hola")
    @ResponseBody
    public String saludo(){
        //return res;
        return "Hola Mundo!";
    }
}
