
package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HelloWorldTest {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/hola")
    @ResponseBody
    public String saludo(){

        return "Hola Mundo!";
    }
    
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    @ResponseBody
    public String saludo(){

        return "Hola Mundo!";
    }
}
