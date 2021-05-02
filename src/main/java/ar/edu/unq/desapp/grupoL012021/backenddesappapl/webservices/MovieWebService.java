package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;


import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class MovieWebService  {

    @Autowired
    private MovieService movieService;

    @PostMapping("/api/movies/save")
    public void addMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @GetMapping("/api/movies")
    public List<Movie> allMovie() {
        List<Movie> list = movieService.findAll();;
        return list;
    }

    @RequestMapping(value = "/api/version", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVersion() {
        String version = "0.2.1";
        Map<String, String> resultado = new HashMap<String, String>();
        resultado.put("version", version);
        return ResponseEntity.ok().body(resultado);
    }

}

