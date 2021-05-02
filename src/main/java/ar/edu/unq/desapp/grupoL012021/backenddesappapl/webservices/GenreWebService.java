package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Genre;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class GenreWebService {

    @Autowired
    private GenreService genreService;

    @GetMapping("/api/genres")
    public List<Genre> allGenres() {
        List<Genre> list = genreService.findAll();
        return list;
    }
}
