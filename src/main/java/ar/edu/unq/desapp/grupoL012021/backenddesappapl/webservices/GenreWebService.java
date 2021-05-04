package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Genre;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@EnableAutoConfiguration
public class GenreWebService {

    @Autowired
    private GenreService genreService;

    @GetMapping("")
    public List<Genre> allGenres() {
        List<Genre> list = genreService.findAll();
        return list;
    }

    @PostMapping
    public Genre save(@RequestBody Genre genre) { return genreService.save(genre); }
}
